<?php
    // db connect layer
    require_once "config.php";
    session_start();
    class DBConnection
    {
        private $db;
        private $uid;

        public function connect()
        {
            $this->db = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
            $this->uid = $_SESSION["uid"];
            return $this->db;
        }
        public function getUid()
        {
            return $this->uid;
        }
        public function getPdo()
        {

            $dsn = "mysql:host=localhost;dbname=classmate;charset=utf8";
            $opt = [
                PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
                PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
                PDO::ATTR_EMULATE_PREPARES   => false,
            ];
            return new PDO($dsn, DB_USER, DB_PASS, $opt);
        }
    }