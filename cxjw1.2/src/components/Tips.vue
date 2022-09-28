<template>
  <div class="tips">
    <h3 class="tips-msg">{{msg}}</h3>
  </div>
</template>

<script>
  export default {
    name: 'Tips',
    data() {
      return {
        msg: '建设中,待续...'
      }
    }
  }
</script>

<style>
  .tips-msg{
    text-align: center;
    color: #0099FF;
    height: 300px;
    line-height: 300px;
  }
</style>
