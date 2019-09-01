import os


directory = os.getcwd()

for file in os.listdir(directory):
    if  file[-5:] != '.java' or file == 'CreateAndPrintStaff.java':
        continue
    print(file)
    os.system('javac ' + file)
