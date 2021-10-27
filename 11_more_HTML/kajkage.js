/*const list = [1, 2, 3, 4, 5];
const isOdd = list.filter(number => number % 2)
console.log(isOdd);

 */

const kajkager = [{
    type : 'Andreas',
    color : "blue",
    deliciousness : 8
}];

kajkager.push({
    type: "kaj",
    color: "green",
    deliciousness: 10
});

const tbodyElement = document.getElementById("cake-tbody");

kajkager.map(cake => {
    const tableRowElement = document.createElement("tr");

    tableRowElement.innerHTML = `
        <td>${escapeHTML(cake.type)}</td>
        <td>${escapeHTML(cake.color)}</td>
        <td>${escapeHTML(cake.deliciousness.toString())}/10</td>
`;

    tbodyElement.appendChild(tableRowElement);
});


