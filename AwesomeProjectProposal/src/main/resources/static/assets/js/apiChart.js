/**
 * This page is create charts using API data
 * ref: https://www.youtube.com/watch?v=FtZwJZB0xb8&t=1s
 */

  var ctx = document.getElementById('homeTeamHead2Head').getContext('2d');

  var Chart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
      datasets: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });