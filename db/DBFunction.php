<?php
    require_once "DBConnection.php";
    require_once "../models/User.php";

    class DBFunction
    {
        private $db;
        private $uidUser;
        public function __construct()
        {
            $connection = new DBConnection();
            $this->db = $connection->connect();
            $this->uidUser = $connection->getUid();
        }
        /**
         * @param User $user
         */
        public function authUser($user)
        {
            
            $query = "INSERT INTO `users`(`uid`, `first_name`, `middle_name`, `last_name`, `school_number`, `school_class`) VALUES('{$user->getUid()}', '{$user->getFirstName()}', '{$user->getMiddleName()}', '{$user->getLastName()}', {$user->getSchoolNumber()}, {$user->getSchoolClass()})";

            $this->db->query($query);
            require_once "../models/ResponseMessage.php";
            if($this->db->error!=null)
            {
                $message = new ResponseMessage();
                $message->sendMessage(2, $this->db-error, ResponseMessage::$FLAG_ERROR);
            }

            return $user;
        }

        public function checkUser($uid)
        {
            $query = "SELECT uid FROM `users` WHERE uid='".$uid."'";
            $result = $this->db->query($query);

            return $result->num_rows>0;
        }
        public function getUser($uid)
        {
            $query = "SELECT * FROM `users` WHERE uid='".$uid."'";
            $result = $this->db->query($query);
            return $result->fetch_assoc();
        }
        public function addData()
        {

        }
    }