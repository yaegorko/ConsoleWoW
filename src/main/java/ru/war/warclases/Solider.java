package ru.war.warclases;

/**
 * Прототип всех классов солдат.
 */
public abstract class Solider {
    /**
     * Здоровье для всех.
     */
    private int health = 100;

    /**
     * Получить здоровье.
     * @return здоровье.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Установить здоровье.
     * @param health здоровье.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Привилегированный или нет.
     * Наложен бафф или нет.
     */
    private boolean isBlesed = false;

    /**
     * Бафнут или нет.
     * @return баффнут или нет.
     */
    public boolean isBlesed() {
        return isBlesed;
    }

    /**
     * Баффнуть или снять бафф. Маги, шаман.
     * @param blesed Баффнуть или снять бафф.
     */
    public void setBlesed(boolean blesed) {
        isBlesed = blesed;
    }

    /**
     * Недуг. Накладывает только некромант нежить.
     */
    private boolean isCursed = false;

    /**
     * Проклят или нет.
     * @return Проклят или нет.
     */
    public boolean isCursed() {
        return isCursed;
    }

    /**
     * Проклясть.
     * @param cursed проклясть.
     */
    public void setCursed(boolean cursed) {
        isCursed = cursed;
    }

    /**
     * Усталость. Атаковал солдат или нет в этот ход.
     */
    private boolean fatigue = false;

    /**
     * Показать усталость.
     * @return усталость.
     */
    public boolean isFatigue() {
        return fatigue;
    }

    /**
     * Снять или установить усталость.
     * @param fatigue усталость.
     */
    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    /**
     * Цель.
     */
    private Solider target;

    /**
     * Получить цель солдата.
      * @return цель.
     */
    public Solider getTarget() {
        return target;
    }

    /**
     * Установить цель.
     * @param target цель.
     */
    public void setTarget(Solider target) {
        this.target = target;
    }

    /**
     * Выбор действия для Магов.
     * @param targetEnemy враг.
     * @param targetAlly друг.
     */
    public void chooseAction(Solider targetEnemy, Solider targetAlly) {

    }

    /**
     * Выбор действия для Воинов и Лучников.
     * @param targetEnemy враг.
     */
    public void chooseAction(Solider targetEnemy) {

    }

    /**
     * Мили атака. Личники и Воины.
     */
    void attack() {

    }

    /**
     * Дистанционная атака. Лучники и Маги.
     */
    void rangeAttack() {

    }

    /**
     * Бафы Маги, Шаман.
     */
    void cast() {

    }

    /**
     * Для вывода в консоль.
     * @return строку.
     */
    public String toString() {
        int n = getClass().getTypeName().lastIndexOf('.');
        String s = getClass().getTypeName().substring(n + 1) + " (" + getHealth() + " HP)";
        return s;
    }
}
