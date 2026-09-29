Lab 04: JUnit 5 Testing

Оюутны мэдээлэл Овог нэр: Н.Баярбаясгалан Оюутны код: B242270012

Орчны хувилбар:Environment Versions Java Version openjdk version "17.0.11" OpenJDK Runtime Environment (build 17.0.11+11-Ubuntu-1ubuntu220.04) OpenJDK Guest 64-Bit Server VM (build 17.0.11+11-Ubuntu-1ubuntu220.04)

Тестийн гүйцэтгэл

Энэхүү лабораторийн ажлаар GradeCalculator классын дүн болон нийлбэр оноо тооцох логикийг бүрэн хөгжүүлж, JUnit 5 ашиглан нэгжийн болон параметржүүлсэн (@ParameterizedTest, @CsvSource) тестүүдийг AAA (Arrange-Act-Assert) бүтцээр бичсэн. Нийтдээ 20 тест амжилттай ажиллаж, results/mvn-test.txt файлд BUILD SUCCESS үр дүнтэйгээр хадгалагдсан. Tests run тоо: 20

Мутацийн тест

Кодын чанар болон тестүүдийг шалгахын тулд GradeCalculator.java доторх score >= 90 гэсэн нөхцөлийг зориудаар өөрчлөөд score > 90 болгож мутаци үүсгэсэн. Энэ үед mvn test командийг ажиллуулахад яг 90 онооны хязгаарыг шалгадаг 2 тест амжилттай унаж, Failures: 2 болон BUILD FAILURE үр дүн гарсан. Энэ нь бичсэн тестүүд хязгаарын утгыг хянаж чадаж байгааг нотолсон. Үүний дараа кодоо буцааж хэвийн байдалд нь оруулж, бүх тестээ дахин амжилттай болгосон
