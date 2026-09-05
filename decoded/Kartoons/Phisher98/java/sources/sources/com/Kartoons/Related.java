package com.Kartoons;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0082\u0001\u0010)\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014¨\u00061"}, d2 = {"Lcom/Kartoons/Related;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_id", "title", "image", "startYear", "", "rating", "", "tags", "", "slug", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Double;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getImage", "getStartYear", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTags", "()Ljava/util/List;", "getSlug", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Double;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/Kartoons/Related;", "equals", "", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Related {

    @JsonProperty("_id")
    @Nullable
    private final String id;

    @Nullable
    private final String image;

    @Nullable
    private final Double rating;

    @Nullable
    private final String slug;

    @Nullable
    private final Long startYear;

    @Nullable
    private final List<String> tags;

    @Nullable
    private final String title;

    @Nullable
    private final String type;

    public Related() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Related copy$default(Related related, String str, String str2, String str3, Long l, Double d, List list, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = related.id;
        }
        if ((i & 2) != 0) {
            str2 = related.title;
        }
        if ((i & 4) != 0) {
            str3 = related.image;
        }
        if ((i & 8) != 0) {
            l = related.startYear;
        }
        if ((i & 16) != 0) {
            d = related.rating;
        }
        if ((i & 32) != 0) {
            list = related.tags;
        }
        if ((i & 64) != 0) {
            str4 = related.slug;
        }
        if ((i & 128) != 0) {
            str5 = related.type;
        }
        String str6 = str4;
        String str7 = str5;
        Double d2 = d;
        List list2 = list;
        return related.copy(str, str2, str3, l, d2, list2, str6, str7);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
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
    public final Long getStartYear() {
        return this.startYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    public final List<String> component6() {
        return this.tags;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final Related copy(@JsonProperty("_id") @Nullable String id, @Nullable String title, @Nullable String image, @Nullable Long startYear, @Nullable Double rating, @Nullable List<String> tags, @Nullable String slug, @Nullable String type) {
        return new Related(id, title, image, startYear, rating, tags, slug, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Related)) {
            return false;
        }
        Related related = (Related) other;
        return Intrinsics.areEqual(this.id, related.id) && Intrinsics.areEqual(this.title, related.title) && Intrinsics.areEqual(this.image, related.image) && Intrinsics.areEqual(this.startYear, related.startYear) && Intrinsics.areEqual(this.rating, related.rating) && Intrinsics.areEqual(this.tags, related.tags) && Intrinsics.areEqual(this.slug, related.slug) && Intrinsics.areEqual(this.type, related.type);
    }

    public int hashCode() {
        return ((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.startYear == null ? 0 : this.startYear.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Related(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", startYear=" + this.startYear + ", rating=" + this.rating + ", tags=" + this.tags + ", slug=" + this.slug + ", type=" + this.type + ')';
    }

    public Related(@JsonProperty("_id") @Nullable String id, @Nullable String title, @Nullable String image, @Nullable Long startYear, @Nullable Double rating, @Nullable List<String> list, @Nullable String slug, @Nullable String type) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.startYear = startYear;
        this.rating = rating;
        this.tags = list;
        this.slug = slug;
        this.type = type;
    }

    public /* synthetic */ Related(String str, String str2, String str3, Long l, Double d, List list, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : d, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5);
    }

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
    public final Long getStartYear() {
        return this.startYear;
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
