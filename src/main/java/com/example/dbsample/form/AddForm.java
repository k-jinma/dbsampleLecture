package com.example.dbsample.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddForm {
    @NotBlank(message = "タイトルは必須です。") // 空白不可
    @Size(max = 255, message = "タイトルは255文字以内で入力してください。")
    private String title;   // 書籍名

    @NotBlank(message = "著者名は必須です。") // 空白不可
    @Size(max = 255, message = "著者名は255文字以内で入力してください。")
    private String author;  // 著者名

    @Positive(message = "出版社を選択してください。")   // 0以下の値は不可
    private int publisherId;    // 出版社ID


}