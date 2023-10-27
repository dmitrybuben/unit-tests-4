package seminars.fourth.card;

public class PaymentForm {
    private CreditCard creditCard;

    public PaymentForm(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void pay(double amount) {
        /*если тут в основном коде после мок-теста внести некие изменения типа ниже, то при регрессе в тесте будет
        видна ошибка
        amount += 100;*/

        creditCard.charge(amount);
    }
}
