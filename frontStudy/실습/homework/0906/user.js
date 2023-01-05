async function onChangeTableData() {
    const url = "https://jsonplaceholder.typicode.com/users";
    let table = document.getElementById("table");
    const response = await fetch(url, {
      method: "GET",
    });

    if (response.ok) {
      let data = await response.json();
      let tbody = document.getElementById("tbody");
      let rowCount = tbody.rows.length;
      console.log(tbody.rows.length);

      let tableHeaderRowCount = 0;
      for (let i = tableHeaderRowCount; i < rowCount; i++) {
        tbody.deleteRow(tableHeaderRowCount);
      }

      data.map((value) => {
        console.log(value);

        const newRow = tbody.insertRow();

        const newCell1 = newRow.insertCell(0);
        const newCell2 = newRow.insertCell(1);
        const newCell3 = newRow.insertCell(2);
        const newCell4 = newRow.insertCell(3);

        //Cell 값 추가
        newCell1.innerText = value.id;
        newCell2.innerText = value.name;
        newCell3.innerText = value.phone;
        newCell4.innerText = value.website;
      });
    }
  }