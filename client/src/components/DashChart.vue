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
      labels: ['Paris', 'Nîmes', 'Toulon', 'Perpignan', 'Autre'],
      datasets: [
        {
          data: [30, 40, 60, 70, 5],
          backgroundColor: ['#77CEFF', '#0079AF', '#123E6B', '#97B0C4', '#A5C8ED'],
        },
      ],
    };

    const data = ref([30, 40, 60, 70, 5]);
    const chartData = computed(() => ({
      labels: ['Paris', 'Nîmes', 'Toulon', 'Perpignan', 'Autre'],
      datasets: [
        {
          data: data.value,
          backgroundColor: ['#77CEFF', '#0079AF', '#123E6B', '#97B0C4', '#A5C8ED'],
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