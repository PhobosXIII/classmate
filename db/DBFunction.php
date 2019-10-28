<?php
    require_once "DBConnection.php";
    require_once "../../models/User.php";

    class DBFunction
    {
        private $pdo;
        private $uidUser;
        public function __construct()
        {
            $connection = new DBConnection();
            $this->pdo = $connection->connect();
            $this->uidUser = $connection->getUid();
        }
        /**
         * @param User $user
         */
        public function authUser($user)
        {

            $query = "INSERT INTO `users`(`uid`, `first_name`, `middle_name`, `last_name`, `school_number`, `school_class`) VALUES('{$user->getUid()}', '{$user->getFirstName()}', '{$user->getMiddleName()}', '{$user->getLastName()}', {$user->getSchoolNumber()}, {$user->getSchoolClass()})";
            $this->pdo->query($query);
            return $user;
        }

        public function getUser($uid)
        {
            $query = "SELECT * FROM `users` WHERE uid='".$uid."'";
            $result = $this->pdo->query($query);
            return $result->fetch_assoc();
        }
        public function addTimetable($number, $date, $title, $cabinet, $class_id)
        {
            $query = "INSERT INTO timetable(number, time, title,cabinet, class_id) VALUES()";

        }

        public function getTimetable($time, $class)
        {
            $query = "SELECT * FROM TIMETABLE WHERE time = ? and class=?";
            $stmt = $this->pdo->prepare($query);
            $stmt->execute([$time, $class]);
            while($row = $stmt->fetch(PDO::FETCH_LAZY))
            {
                echo $row['first_name'];
            }
        }

    }