person_n = int(input())

while person_n != 0:
    name, height = input().split()
    for i in range(1, person_n ):
        new_name, new_height = input().split()
        height = float(height)
        new_height = float(new_height)
        if height < new_height:
            height = new_height
            name = new_name
        elif height <= new_height:
            name += ' ' + new_name
    print(name)
    person_n = int(input())