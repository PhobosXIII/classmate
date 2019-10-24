<?php 
    class User
    {
        private $uid;
        private $firstName;
        private $lastName;
        private $middleName;
        private $schoolNumber;
        private $schoolClass;
        public function __construct($uid,$firstName, $middleName, $lastName, $schoolNumber, $schoolClass)
        {
            $this->uid = $uid;
            $this->firstName = $firstName;
            $this->lastName = $lastName;
            $this->middleName = $middleName;
            $this->schoolNumber = $schoolNumber;
            $this->schoolClass = $schoolClass;
        }




        /**
         * @return string
         */
        public function getUid()
        {
            return $this->uid;
        }

        /**
         * @param string $uid
         */
        public function setUid($uid)
        {
            $this->uid = $uid;
        }

        /**
         * @return mixed
         */
        public function getFirstName()
        {
            return $this->firstName;
        }

        /**
         * @param mixed $firstName
         */
        public function setFirstName($firstName)
        {
            $this->firstName = $firstName;
        }

        /**
         * @return mixed
         */
        public function getLastName()
        {
            return $this->lastName;
        }

        /**
         * @param mixed $lastName
         */
        public function setLastName($lastName)
        {
            $this->lastName = $lastName;
        }

        /**
         * @return mixed
         */
        public function getMiddleName()
        {
            return $this->middleName;
        }

        /**
         * @param mixed $middleName
         */
        public function setMiddleName($middleName)
        {
            $this->middleName = $middleName;
        }

        /**
         * @return mixed
         */
        public function getSchoolNumber()
        {
            return $this->schoolNumber;
        }

        /**
         * @param mixed $schoolNumber
         */
        public function setSchoolNumber($schoolNumber)
        {
            $this->schoolNumber = $schoolNumber;
        }

        /**
         * @return mixed
         */
        public function getSchoolClass()
        {
            return $this->schoolClass;
        }

        /**
         * @param mixed $schoolClass
         */
        public function setSchoolClass($schoolClass)
        {
            $this->schoolClass = $schoolClass;
        }

        public function __toString()
        {
           return "Unique id: ".$this->getUid().", first name: ".$this->getFirstName().", middle name:".$this->getMiddleName().", last name: ".$this->getLastName().", "."school number: ".$this->getSchoolNumber().", school class: ".$this->getSchoolClass();
        }
        function getJsonData(){
            $var = get_object_vars($this);
            foreach ($var as &$value) {
                if (is_object($value) && method_exists($value,'getJsonData')) {
                    $value = $value->getJsonData();
                }
            }
            return $var;
        }


    }    
?>