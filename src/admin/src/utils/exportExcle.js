//用于导出EXCLE的文件格式 
import * as XLSX from "xlsx/xlsx.mjs"
import * as $ from "jquery"
const exportExcle = {
  tableTocsv(table) {
    var csv = [];
    $(table).find("tr").each(function () {
      var temp = [];
      $(this).find("td").each(function () {
        temp.push($(this).html())
      })
      temp.shift()
      csv.push(temp.join(','))
    })
    csv.shift()
    return csv.join("\n");
  },
  //将csv格式转成 sheet对象
  csvTosheet(csv) {
    var sheet = {};
    csv = csv.split("\n");
    csv.forEach(function (row, i) {
      row = row.split(",");
      if (i == 0) sheet['!ref'] = "A1:" + String.fromCharCode(65 + row.length - 1) + (csv.length - 1);
      row.forEach(function (col, j) {
        sheet[String.fromCharCode(65 + j) + (i + 1)] = { v: col };
      })
    })
    return sheet;
  },
  //将一个sheet对象转成最终的excel文件的blob对象 然后下载
  sheetToblob(sheet, sheetName) {
    sheetName = sheetName || "sheet1"
    var workbook = {
      SheetNames: [sheetName],
      Sheets: {}
    }
    workbook.Sheets[sheetName] = sheet;
    //生成excel的配置项
    var wopts = {
      bookType: "xlsx",
      bookSST: false,
      type: "binary"
    }
    var wbout = XLSX.write(workbook, wopts);
    var blob = new Blob([sab(wbout)], { type: "application/octet-stream" });
    //把字符串转化成 arrayBuffer(类型化数组)
    function sab(s) {
      var buf = new ArrayBuffer(s.length);
      var view = new Uint8Array(buf);
      for (var i = 0; i != s.length; i++) view[i] = s.charCodeAt(i) & 0xFF;
      return buf
    }
    return blob
  },
  //通用的打开下载对话框方法
  openDownloadDialog(url, saveName) {
    if (typeof url == "object" && url instanceof Blob) {
      url = URL.createObjectURL(url); //创建blob地址
    }
    var aLink = document.createElement("a");
    aLink.href = url;
    aLink.download = saveName || "";
    var event;
    if (window.MouseEvent) event = new MouseEvent("click");
    else {
      event = document.createEvent("MouseEvents");
      event.initMouseEvent("click", true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
    }
    //触发事件
    aLink.dispatchEvent(event)
  },
}
export default exportExcle

