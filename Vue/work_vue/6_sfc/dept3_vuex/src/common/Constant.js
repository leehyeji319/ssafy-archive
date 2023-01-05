//불변객체로 만들어 쓰고싶다면? Object.freeze !! 
export default Object.freeze ({//상수로 쓰고싶다면???
  GET_DEPTS: "getDepts", //실제 사용할 이름은 오른쪽. 외부는 왼쪽
  SET_DEPTS: "setDepts",
  REGISTER_DEPT: "registerDept",
  GET_DEPT: "getDept",
  SET_DEPT: "setDept",
  MODIFY_DEPT: "modifyDept",
})