package Model;

import java.util.Random;

public class BattlePhase {

    private CreatureEvo1 CPlayerCreature;
    private CreatureEvo1 CEnemyCreature;

    private Random CRandom;

    private Sound CSound;

    private int nEnemyHP;

    private int nMoves;

    public BattlePhase(CreatureEvo1 CPlayerCreature, CreatureEvo1 CEnemyCreature) {
        this.CPlayerCreature = CPlayerCreature;
        this.CEnemyCreature = CEnemyCreature;
        this.CRandom = new Random();
        this.CSound = Sound.getInstance();
        this.nEnemyHP = 50;
        this.nMoves = 3;
    }

    /**
     * This method determines if the player's creature is stronger than the enemy creature based on their types.
     * @return true if the player's creature is stronger, false otherwise.
     */
    private boolean isEnemyWeaker() {
        switch(this.CPlayerCreature.getType()) {
            case "Fire":
                if(this.CEnemyCreature.getType().equals("Grass"))
                    return true;
            case "Grass":
                if(this.CEnemyCreature.getType().equals("Water"))
                    return true;
            case "Water":
                if(this.CEnemyCreature.getType().equals("Fire"))
                    return true;
        }
        return false;
    }

    public int playerAttack() {
        int nDamage = 0;
        int nRandomNum = this.CRandom.nextInt(10) + 1;
        if(this.isEnemyWeaker()) {
            nDamage = (int)Math.round(nRandomNum * this.CPlayerCreature.getLevel() * 1.5);
            this.nEnemyHP -= nDamage;
        } else {
            nDamage = nRandomNum * this.CPlayerCreature.getLevel();
            this.nEnemyHP -= nDamage;
        }
        this.nMoves--;
        if(this.nMoves == 0) {
            this.CSound.play("running_away_sound.mp3", 1);
        }
        return nDamage;
    }

    public boolean catchCreature(Player CPlayer) throws Exception {
        double dCatchRate = Math.round(40 + 50 - this.nEnemyHP) * .100;
        int nRandomNum = this.CRandom.nextInt(10) + 1;
        int nID = 1;
        if(nRandomNum < dCatchRate) {
            this.CSound.play("successful_catch.wav", 1);
            for(CreatureEvo1 CCreature : CPlayer.getPlayerInventory().getCreatures()) {
                    this.CEnemyCreature.setID(nID);
                    nID++;
            }
            CPlayer.getPlayerInventory().addCreature(this.CEnemyCreature);
            return true;
        } else {
            this.nMoves--;
            if(this.nMoves == 0) {
                this.CSound.play("running_away_sound.mp3", 1);
            }
            return false;
        }
    }

    /* Getter and Setters */

    public CreatureEvo1 getPlayerCreature() {
        return CPlayerCreature;
    }

    public void setPlayerCreature(CreatureEvo1 CPlayerCreature) {
        this.CPlayerCreature = CPlayerCreature;
    }

    public CreatureEvo1 getEnemyCreature() {
        return CEnemyCreature;
    }

    public void setEnemyCreature(CreatureEvo1 CEnemyCreature) {
        this.CEnemyCreature = CEnemyCreature;
    }

    public int getEnemyHP() {
        return nEnemyHP;
    }

    public void setEnemyHP(int nEnemyHP) {
        this.nEnemyHP = nEnemyHP;
    }

    public int getMoves() {
        return nMoves;
    }

    public void setMoves(int nMoves) {
        this.nMoves = nMoves;
    }

}
