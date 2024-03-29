package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Article> articleList = new ArrayList<>();
        System.out.println("==기사문==");
        int id = 1;

        while (true) {
            System.out.println("명령: ");
            String article = sc.nextLine();
            if (article.equals("등록")) {
                System.out.print("제목: ");
                String title = sc.nextLine();
                System.out.print("내용: ");
                String content = sc.nextLine();
                System.out.println(id + "값이 등록되었습니다.");
                Article originArticle = new Article(id, title, content);
                articleList.add(originArticle);

                id++;
            } else if (article.equals("목록")) {
                System.out.println("번호 / 제목 / 명언");
                System.out.println("----------------------");
                for (Article newArticle : articleList) {
                    System.out.println(newArticle.id + "/" + newArticle.title + "/" + newArticle.content);
                }
            } else if (article.equals("삭제")) {
                System.out.println("삭제할 값을 입력해주세요: ");
                int deleteId = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < articleList.size(); i++) {
                    Article exArticle = articleList.get(i);
                    if (exArticle.getId() == deleteId) {
                        articleList.remove(exArticle);
                    }
                }
                System.out.println(deleteId + "번 기사는 존재하지 않습니다.");
            } else if (article.equals("수정")) {
                System.out.println("수정할 Id의 값을 입력해주세요: ");
                int modifyId = Integer.parseInt(sc.nextLine());
                for (int j = 0; j < articleList.size(); j++) {
                    Article oddArticle = articleList.get(j);
                    System.out.printf("기존 내용: %s \n", oddArticle.getContent());
                    String content = sc.nextLine();
                    oddArticle.setContent(content);

                    System.out.printf("기존 제목: %s \n", oddArticle.getTitle());
                    String title = sc.nextLine();
                    oddArticle.setTitle(title);

                }
                System.out.println(modifyId + "가 수정되었습니다.");
            } else if (article.equals("종료")) {
                break;
            }

        }
        sc.close();
    }

}



