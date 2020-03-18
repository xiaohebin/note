






import * as timeformat from "dateformat";

//获取当前日期
export const getCurrDate = function() {
    let date = new Date();
    let seperator = "-";
    let year = date.getFullYear();
    let month = "";
    let strDate = "";
    if (date.getMonth() + 1 >= 1 && date.getMonth() + 1 <= 9) {
      month = "0";
    }
    if (date.getDate() >= 0 && date.getDate() <= 9) {
      strDate = "0";
    }
    month += date.getMonth() + 1;
    strDate += date.getDate();
    return year + seperator + month + seperator + strDate;
  };
  
  //获取当前年月
  export const getCurrYearMonth = function() {
    let date = new Date();
    let year = date.getFullYear();
    let month = "";
    if (date.getMonth() + 1 >= 1 && date.getMonth() + 1 <= 9) {
      month = "0";
    }
    month += date.getMonth() + 1;
    return year + month;
  };
  
  //获取当前日期到分
  export const getCurrentDate = function() {
    let now = new Date().toLocaleString();
    let time = new Date(now);
    return timeformat(time, "yyyy-mm-dd HH:MM");
  };
  
  //获取当前日期
  export const getCurrentDateTime = function() {
    let now = new Date().toLocaleString();
    let time = new Date(now);
    return timeformat(time, "yyyy-mm-dd");
  };
  
  //获取当前日期到秒
  export const getLocalDate = function() {
    let now = new Date().toLocaleString();
    let time = new Date(now);
    return timeformat(time, "yyyy-mm-dd HH:MM:ss");
  };
  
  //格式化日期到秒
  export const formatTime = function(time) {
    return timeformat(new Date(time), "yyyy-mm-dd HH:MM:ss");
  };
  
  //格式化日期到日
  export const formatDate = function(time) {
    return timeformat(new Date(time), "yyyy-mm-dd");
  };
  
  // 格式化日期，获取日期到秒
  export const formatDateSec = (time: any) => {
    const Dates = new Date(time);
    const year: number = Dates.getFullYear();
    const month: any =
      Dates.getMonth() + 1 < 10
        ? "0" + (Dates.getMonth() + 1)
        : Dates.getMonth() + 1;
    const day: any =
      Dates.getDate() < 10 ? "0" + Dates.getDate() : Dates.getDate();
  
    const hours: any = 23;
    const minutes: any = 59;
    const sconds: any = 59;
    // const hours: any = Dates.getHours() < 10 ? '0' + Dates.getHours() : Dates.getHours();
    // const minutes: any = Dates.getMinutes() < 10 ? '0' + Dates.getMinutes() : Dates.getMinutes();
    // const sconds: any = Dates.getSeconds() < 10 ? '0' + Dates.getSeconds() : Dates.getSeconds();
  
    return (
      year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + sconds
    );
  };