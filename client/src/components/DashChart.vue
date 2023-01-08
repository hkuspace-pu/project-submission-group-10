<template>
  <div class="chartController">
    <DoughnutChart ref="doughnutRef" :chartData="testData" @chart:render="handleChartRender" />
    <BarChart v-bind="barChartProps" />
  </div>
  
</template>
<script>
import { ref, computed, defineComponent } from 'vue';
import { Chart, registerables } from "chart.js";
import { DoughnutChart, LineChart, useLineChart, BarChart, useBarChart } from 'vue-chart-3';

Chart.register(...registerables);

export default defineComponent({
  name: 'Chart',
  components: { DoughnutChart, LineChart, BarChart },
  setup() {
    const testData = {
      labels: ['North', 'Sha Tin', 'Yau Tsim Mong', 'Kwun Tong', 'Central and Western', 'Islands'],
      datasets: [
        {
          data: [30, 40, 60, 70, 5, 20],
          backgroundColor: ['#C67C5C', '#3E868E', '#E1B878', '#75ACC0', '#87986A', '#CFE1AC'],
        },
      ],
    };

    const data = ref([30, 40, 60, 70, 5]);
    const chartData = computed(() => ({
      labels: ['2022-07', '2022-08', '2022-09', '2022-10', '2022-11', '2022-12'],
      datasets: [
        {
          data: data.value,
          backgroundColor: ['#C67C5C', '#3E868E', '#E1B878', '#75ACC0', '#87986A', '#CFE1AC'],
        },
      ],
    }));

    const { barChartProps, barChartRef } = useBarChart({
      chartData,
    });

    return { testData, barChartProps, barChartRef };
  },
});
</script>

<style>
  .chartController {
    margin: 20px;
  }
</style>