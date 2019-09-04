import os


directory = os.getcwd()

for file in os.listdir(directory):
    if  file[-5:] != '.java':
        continue
    print(file)
    os.system('javac ' + file)

classStr = "jar -cfvm ExtraCredit1.jar Manifest.txt Readme.txt "

for file in os.listdir(directory):
    if  file[-6:] != '.class':
        continue
    print(file)
    classStr = classStr + file + " "

print(classStr)

os.system(classStr)
