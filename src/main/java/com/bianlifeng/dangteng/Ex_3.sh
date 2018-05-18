#查询给定文件包含至少有5个连续小写字符的行，并将结果写入result.txt 文件中，使用一条命令完成

less test.txt | grep '[a-z]\{5\}'  > result.txt