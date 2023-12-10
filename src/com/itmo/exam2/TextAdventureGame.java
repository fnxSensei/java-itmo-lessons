package com.itmo.exam2;

import java.io.*;
import java.util.Scanner;

class TextAdventureGame {
    private MenuItem startGameMenuItem;
    private MenuItem continueGameMenuItem;
    private MenuItem exitGameMenuItem;
    private MenuItem saveGameMenuItem;
    private MenuItem loadGameMenuItem;
    private Paragraph currentParagraph;


    public TextAdventureGame() {
        startGameMenuItem = new MenuItem("Начать игру");
        continueGameMenuItem = new MenuItem("Вернуться к игре");
        exitGameMenuItem = new MenuItem("Выйти из игры");
        saveGameMenuItem = new MenuItem("Сохранить игру");
        loadGameMenuItem = new MenuItem("Загрузить игру");
        currentParagraph = null;
    }

    public void start() {
        boolean isRunning = true;
        printMenu();

        while (isRunning) {


            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    continueGame();
                    break;
                case 3:
                    exitGame();
                    isRunning = false;
                    break;
                case 4:
                    saveGame();
                    break;
                case 5:
                    loadGame();
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
    private void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. " + startGameMenuItem.getName());
        System.out.println("2. " + continueGameMenuItem.getName());
        System.out.println("3. " + exitGameMenuItem.getName());
        if (currentParagraph != null) {
            System.out.println("4. " + saveGameMenuItem.getName());
        }
        if (currentParagraph == null) {
            System.out.println("5. " + loadGameMenuItem.getName());
        }
        System.out.print("Выберите пункт меню: ");
    }

    private void startGame() {

        Paragraph lisenok = new Paragraph("Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. Лисёнок пришёл на\n" +
                "их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. \"\n" +
                "Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок. Как поступить Лисенку?", "вернуться домой", "отправиться на поиски", false);
        Paragraph vernutsya = new Paragraph("Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой\n" +
                "злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга! Игра\n" +
                "завершилась успехом", null, null, true);
        Paragraph poiski = new Paragraph("Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. Но вдруг кто нибудь видел\n" +
                "Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.", "попытаться разузнать о бельчонке у лесных жителей", "искать бельчонка в одиночку", false);
        Paragraph razuznat = new Paragraph("Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. Но у Совы бывают проблемы\n" +
                "с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?", "расспросить сову", "расспросить волка", false);
        Paragraph iskatOdnomy = new Paragraph("Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.\n" +
                "Игра завершилась неудачей", null, null, true);
        Paragraph rassprositSovu = new Paragraph("Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего вглубь леса. Все лесные\n" +
                "жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.", "поверить сове и отправиться вглубь леса", "сове не стоит верить -> искать бельчонка в одиночку", false);
        Paragraph rassprositVolka = new Paragraph("Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу\n" +
                "одному. И как теперь поступить?", "волк прав -> вернуться домой", "-> искать бельчонка в одиночку", false);
        Paragraph vglub = new Paragraph("В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, что знает, если Лисёнок\n" +
                "принесёт ему мёда.", "нет, потрачено слишком много времени, нужно идти дальше -> искать бельчонка в одиночку", "нужно воспользоваться шансом и раздобыть мёд", false);
        Paragraph razdobytMed = new Paragraph("Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, но и не найти друга он тоже\n" +
                "боялся.", "подождать, вдруг пчёлы улетят", "нужно попытаться выкрасть мёд немедленно", false);
        Paragraph podojdat = new Paragraph("Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. Вдруг он понял, что очень голоден. Что же делать?", "Поесть немного и передохнуть",
                "Скорее отнести мёд Медвежонку", false);
        Paragraph nemedlenno = new Paragraph("Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь. Игра завершилась неудачей", null, null, true);
        Paragraph poestOtdohnyt = new Paragraph("Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, он не сможет продолжить поиски. Игра\n" +
                "завершилась неудачей", null, null, true);
        Paragraph otnestiMedvedy = new Paragraph("Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, " +
                "что Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности, " +
                "и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой." , "Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку" ,
                "Может быть он прав и Лисёнок просто паникует -> Вернуться домой", false);


        lisenok.setNextParagraph1(vernutsya);
        lisenok.setNextParagraph2(poiski);
        poiski.setNextParagraph1(razuznat);
        poiski.setNextParagraph2(iskatOdnomy);
        razuznat.setNextParagraph1(rassprositSovu);
        razuznat.setNextParagraph2(rassprositVolka);
        rassprositSovu.setNextParagraph1(vglub);
        rassprositSovu.setNextParagraph2(iskatOdnomy);
        rassprositVolka.setNextParagraph1(vernutsya);
        rassprositVolka.setNextParagraph2(iskatOdnomy);
        vglub.setNextParagraph1(iskatOdnomy);
        vglub.setNextParagraph2(razdobytMed);
        razdobytMed.setNextParagraph1(podojdat);
        razdobytMed.setNextParagraph2(nemedlenno);
        podojdat.setNextParagraph1(poestOtdohnyt);
        podojdat.setNextParagraph2(otnestiMedvedy);
        otnestiMedvedy.setNextParagraph2(vernutsya);
        otnestiMedvedy.setNextParagraph2(iskatOdnomy);


        currentParagraph = lisenok;

        System.out.println("Игра началась!"); //Начните с выбора пункта меню 'Вернуться к игре' для продолжения.");
        continueGame();

    }


    private void continueGame() {
        boolean running = true;
        while (running) {
            if (currentParagraph != null) {
                System.out.println(currentParagraph.getText());
                System.out.println("1. " + currentParagraph.getOption1());
                System.out.println("2. " + currentParagraph.getOption2());
                System.out.println("0. Выход в главное меню");

                Scanner scanner = new Scanner(System.in);
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        currentParagraph = currentParagraph.getNextParagraph1();
                        break;
                    case 2:
                        currentParagraph = currentParagraph.getNextParagraph2();
                        break;
                    case 0:
                        running=false;
                        break;
                    default:
                        System.out.println("Некорректный выбор. Попробуйте снова.");
                }
                if (currentParagraph.isEnd()) {
                    System.out.println(currentParagraph.getText());
                    System.out.println("Игра окончена!");
                    currentParagraph = null;
                    running=false;
                }
            } else {
                System.out.println("Нет сохраненной игры.");
                printMenu();
                running=false;
            }
        }
        printMenu();
    }
    private void exitGame() {
        currentParagraph=null;
        System.out.println("Игра завершена.");
        System.exit(0);
    }
    private void saveGame() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("game.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(currentParagraph);
            System.out.println("Игра сохранена.");
            printMenu();
        } catch (IOException e) {
            System.out.println("Ошибка сохранения игры.");
        }
    }
    private void loadGame() {
        File gameFile = new File("game.bin");
        if (gameFile.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(gameFile);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                currentParagraph = (Paragraph) objectInputStream.readObject();
                continueGame();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Ошибка загрузки игры.");
                startGame();
            }
        } else {
            startGame();
        }
    }
}
