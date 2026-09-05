package com.Kartoons;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kartoons/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008c\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u000205HÖ\u0081\u0004J\n\u00106\u001a\u00020\u0003HÖ\u0081\u0004R#\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013¨\u00067"}, d2 = {"Lcom/Kartoons/Data;", "", "id", "", "title", "image", "coverImage", "hoverImage", "releaseYear", "", "rating", "", "tags", "", "slug", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Double;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_id", "getTitle", "getImage", "getCoverImage", "getHoverImage", "getReleaseYear", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTags", "()Ljava/util/List;", "getSlug", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Double;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/Kartoons/Data;", "equals", "", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Data {

    @Nullable
    private final String coverImage;

    @Nullable
    private final String hoverImage;

    @Nullable
    private final String id;

    @Nullable
    private final String image;

    @Nullable
    private final Double rating;

    @Nullable
    private final Long releaseYear;

    @Nullable
    private final String slug;

    @Nullable
    private final List<String> tags;

    @Nullable
    private final String title;

    @Nullable
    private final String type;

    public Data() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, String str4, String str5, Long l, Double d, List list, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = data.id;
        }
        if ((i & 2) != 0) {
            str2 = data.title;
        }
        if ((i & 4) != 0) {
            str3 = data.image;
        }
        if ((i & 8) != 0) {
            str4 = data.coverImage;
        }
        if ((i & 16) != 0) {
            str5 = data.hoverImage;
        }
        if ((i & 32) != 0) {
            l = data.releaseYear;
        }
        if ((i & 64) != 0) {
            d = data.rating;
        }
        if ((i & 128) != 0) {
            list = data.tags;
        }
        if ((i & 256) != 0) {
            str6 = data.slug;
        }
        if ((i & 512) != 0) {
            str7 = data.type;
        }
        String str8 = str6;
        String str9 = str7;
        Double d2 = d;
        List list2 = list;
        String str10 = str5;
        Long l2 = l;
        return data.copy(str, str2, str3, str4, str10, l2, d2, list2, str8, str9);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getHoverImage() {
        return this.hoverImage;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getReleaseYear() {
        return this.releaseYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    public final List<String> component8() {
        return this.tags;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    public final Data copy(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String coverImage, @Nullable String hoverImage, @Nullable Long releaseYear, @Nullable Double rating, @Nullable List<String> tags, @Nullable String slug, @Nullable String type) {
        return new Data(id, title, image, coverImage, hoverImage, releaseYear, rating, tags, slug, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.title, data.title) && Intrinsics.areEqual(this.image, data.image) && Intrinsics.areEqual(this.coverImage, data.coverImage) && Intrinsics.areEqual(this.hoverImage, data.hoverImage) && Intrinsics.areEqual(this.releaseYear, data.releaseYear) && Intrinsics.areEqual(this.rating, data.rating) && Intrinsics.areEqual(this.tags, data.tags) && Intrinsics.areEqual(this.slug, data.slug) && Intrinsics.areEqual(this.type, data.type);
    }

    public int hashCode() {
        return ((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.hoverImage == null ? 0 : this.hoverImage.hashCode())) * 31) + (this.releaseYear == null ? 0 : this.releaseYear.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Data(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", coverImage=" + this.coverImage + ", hoverImage=" + this.hoverImage + ", releaseYear=" + this.releaseYear + ", rating=" + this.rating + ", tags=" + this.tags + ", slug=" + this.slug + ", type=" + this.type + ')';
    }

    public Data(@Nullable String id, @Nullable String title, @Nullable String image, @Nullable String coverImage, @Nullable String hoverImage, @Nullable Long releaseYear, @Nullable Double rating, @Nullable List<String> list, @Nullable String slug, @Nullable String type) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.coverImage = coverImage;
        this.hoverImage = hoverImage;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.tags = list;
        this.slug = slug;
        this.type = type;
    }

    public /* synthetic */ Data(String str, String str2, String str3, String str4, String str5, Long l, Double d, List list, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : d, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7);
    }

    @JsonProperty("_id")
    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getCoverImage() {
        return this.coverImage;
    }

    @Nullable
    public final String getHoverImage() {
        return this.hoverImage;
    }

    @Nullable
    public final Long getReleaseYear() {
        return this.releaseYear;
    }

    @Nullable
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }
}
