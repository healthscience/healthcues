<template>
  <Page>
    <ActionBar title="heathCues" />
    <GridLayout rows="auto,*" columns="*" class="page">
      <Label row="0" class="title" text="healthCues from BentoBoxDS" />
      <GridLayout row="1" class="grid" columns="*,*" rows="auto,auto,auto">
        <Label row="0" col="0" class="tile" text="Tile 1" />
        <Label row="0" col="1" class="tile" text="Tile 2" />
        <Label row="1" col="0" class="tile" text="Tile 3" />
        <Label row="1" col="1" class="tile" text="Tile 4" />
        <Label row="2" col="0" class="tile" text="Tile 5" />
        <Label row="2" col="1" class="tile" text="Tile 6" />
      </GridLayout>
    </GridLayout>
  </Page>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style scoped>
.page {
  padding: 16;
}
.title {
  font-size: 20;
  font-weight: bold;
  margin: 8 0;
}
.grid {
  gap: 8; /* NativeScript uses margins; gap is ignored but kept as hint */
}
.tile {
  border-width: 1;
  border-color: #ccc;
  padding: 16;
  margin: 4;
  text-align: center;
}
</style>
