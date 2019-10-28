
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Авторизация</title>
</head>
<body>
<h2>Авторизация</h2>
<form method="POST" action="auth.php">
    <input type="text" name="uid" placeholder="uid"><br/>
    <input type="text" name="first_name" placeholder="Имя"><br/>
    <input type="text" name="last_name" placeholder="Фамилия"><br/>
    <input type="text" name="middle_name" placeholder="Отчество"><br/>
    <input type="text" name="school_number" placeholder="Номер школы"><br/>
    <input type="text" name="school_class" placeholder="Класс"><br/>
    <input type="submit" name="submit">
</form>
</body>
</html>