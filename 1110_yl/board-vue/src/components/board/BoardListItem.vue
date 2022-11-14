<template>
  <tr>
    <td>{{ article.articleno }}</td>
    <td>
      <!-- 글번호 가져와야함 -->
      <router-link :to="`/board/view/${article.articleno}`">
        {{ article.subject }}
      </router-link>
    </td>
    <td>{{ article.userid }}</td>
    <td>{{ article.hit }}</td>
    <td>{{ article.regtime }}</td>
  </tr>
</template>

<script>
export default {
  name: "BoardListItem",
  props: {
    article: Object,
  },
};
</script>

<style></style>
