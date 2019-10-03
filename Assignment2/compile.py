import os

directory = os.getcwd()

for file in os.listdir(directory):
    if  file[-5:] != '.java':
        continue
    print(file)
    os.system('javac ' + file)

classStr = "jar -cfvm HW1.jar Manifest.txt Readme.txt "

for file in os.listdir(directory):
    if  file[-6:] != '.class':
        continue
    print(file)
    classStr = classStr + file + " "

print(classStr)

for file in os.listdir(directory):
    if file[-6:] == '.class':
        os.remove(file)

os.system(classStr)
