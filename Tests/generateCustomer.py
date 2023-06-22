#create a csv file with 100 customers
import csv

with open('customers.csv', mode='w') as csv_file:
    fieldnames = ['email', 'password']
    writer = csv.DictWriter(csv_file, fieldnames=fieldnames)
    writer.writeheader()
    for i in range(1, 540):
        writer.writerow({'email': 'customer' + str(i) + '@example.com', 'password': 'password' + str(i)})
