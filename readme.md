Параметры программы задаются при запуске через аргументы командной строки:
1. задание пути для результатов -o, необязательный, по умолчанию результаты располагаются в текущей папке;
2. префикс имен выходных файлов -p, необязательный, по умолчанию имена integers.txt, floats.txt, strings.txt;
3. режим добавления в существующие файлы -a, необязательный, по умолчанию файлы результатов перезаписываются;
4. выбор статистики краткая или полная -s и -f соответственно
5. остальные параметры – имена входных файлов, не менее одного
6. разделитель дробной части в вещественных числах - символ . или ,

Примеры запуска из командной строки для Windows:  
java -jar util.jar -s -a -p sample- in1.txt in2.txt  
java -jar util.jar -f -o /some/path in1.txt in2.txt

Особенности реализации:  
• среда разработки intellij idea  
• версия JDK 1.8  
• сборка gradle-6.8  
• использовалась стороняя библиотека JewelCli('com.lexicalscope.jewelcli:jewelcli:0.8.9')  