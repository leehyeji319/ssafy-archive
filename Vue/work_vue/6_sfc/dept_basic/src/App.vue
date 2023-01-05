<template>
  <div id="app">
    <dept-view></dept-view>
  </div>
</template>

<script>
import DeptView from './views/DeptView.vue'

export default {
  name: 'App',
  components: {
    DeptView
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
