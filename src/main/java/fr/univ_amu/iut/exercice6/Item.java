package fr.univ_amu.iut.exercice6;

/// Article d'inventaire de la Gilded Rose.
///
/// À la demande de la direction, cette classe est **immuable de signature** :
/// vous ne devez pas changer ses champs ni ses accesseurs (un ami d'enfance de
/// la propriétaire l'a écrite et il ne veut pas qu'on y touche). Vous pouvez
/// créer d'autres classes autour.
class Conjured extends Item {
  public Conjured(Item item) {
    super(item.name, item.sellIn, item.quality);
  }

  public boolean isConjured() {
    return this.name.startsWith("Conjured ");
  }
}

class Normal extends Item {
  public Normal(Item item) {
    super(item.name, item.sellIn, item.quality);
  }

  public Normal UpdateNormal() {
    this.sellIn -= 1;
    if (this.quality > 0)
      if (this.sellIn < 0 && this.quality > 1) this.quality -= 2;
      else this.quality -= 1;
    return this;
  }
}

class Brie extends Item {
  public Brie(Item item) {
    super(item.name, item.sellIn, item.quality);
  }

  public Brie UpdateBrie() {
    this.sellIn -= 1;
    if (this.sellIn < 0 && this.quality < 49) quality += 2;
    if (this.sellIn >= 0 && this.quality < 50) quality += 1;
    return this;
  }
}

class Backstage extends Item {
  public Backstage(Item item) {
    super(item.name, item.sellIn, item.quality);
  }

  public Backstage UpdateBackstage() {
    if (this.sellIn > 0 && this.quality < 50) {
      if (this.sellIn < 11 && this.quality < 49) {
        if (this.sellIn < 6 && this.quality < 48) {
          this.quality += 3;
        } else this.quality += 2;
      } else this.quality += 1;
    } else this.quality = 0;
    return this;
  }
}

public class Item {

  public String name;
  public int sellIn;
  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return name + ", " + sellIn + ", " + quality;
  }
}
