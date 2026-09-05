package com.Coflix;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Goojara/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u008b\u0001\u0010*\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0016\b\u0003\u0010\u000b\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004J\n\u00100\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017¨\u00061"}, d2 = {"Lcom/Coflix/Search2;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "ID", "title", "", "excerpt", "url", "postType", "post_type", "year", "rating", "image", "director", "cast", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getExcerpt", "getUrl", "getPostType", "getYear", "getRating", "getImage", "getDirector", "getCast", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Goojara"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Search2 {

    @Nullable
    private final String cast;

    @NotNull
    private final String director;

    @NotNull
    private final String excerpt;
    private final long id;

    @NotNull
    private final String image;

    @NotNull
    private final String postType;

    @NotNull
    private final String rating;

    @NotNull
    private final String title;

    @NotNull
    private final String url;

    @NotNull
    private final String year;

    public static /* synthetic */ Search2 copy$default(Search2 search2, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            j = search2.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = search2.title;
        }
        return search2.copy(j2, str, (i & 4) != 0 ? search2.excerpt : str2, (i & 8) != 0 ? search2.url : str3, (i & 16) != 0 ? search2.postType : str4, (i & 32) != 0 ? search2.year : str5, (i & 64) != 0 ? search2.rating : str6, (i & 128) != 0 ? search2.image : str7, (i & 256) != 0 ? search2.director : str8, (i & 512) != 0 ? search2.cast : str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCast() {
        return this.cast;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getExcerpt() {
        return this.excerpt;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPostType() {
        return this.postType;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRating() {
        return this.rating;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDirector() {
        return this.director;
    }

    @NotNull
    public final Search2 copy(@JsonProperty("ID") long id, @NotNull String title, @NotNull String excerpt, @NotNull String url, @JsonProperty("post_type") @NotNull String postType, @NotNull String year, @NotNull String rating, @NotNull String image, @NotNull String director, @Nullable String cast) {
        return new Search2(id, title, excerpt, url, postType, year, rating, image, director, cast);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Search2)) {
            return false;
        }
        Search2 search2 = (Search2) other;
        return this.id == search2.id && Intrinsics.areEqual(this.title, search2.title) && Intrinsics.areEqual(this.excerpt, search2.excerpt) && Intrinsics.areEqual(this.url, search2.url) && Intrinsics.areEqual(this.postType, search2.postType) && Intrinsics.areEqual(this.year, search2.year) && Intrinsics.areEqual(this.rating, search2.rating) && Intrinsics.areEqual(this.image, search2.image) && Intrinsics.areEqual(this.director, search2.director) && Intrinsics.areEqual(this.cast, search2.cast);
    }

    public int hashCode() {
        return (((((((((((((((((Search2$$ExternalSyntheticBackport0.m4m(this.id) * 31) + this.title.hashCode()) * 31) + this.excerpt.hashCode()) * 31) + this.url.hashCode()) * 31) + this.postType.hashCode()) * 31) + this.year.hashCode()) * 31) + this.rating.hashCode()) * 31) + this.image.hashCode()) * 31) + this.director.hashCode()) * 31) + (this.cast == null ? 0 : this.cast.hashCode());
    }

    @NotNull
    public String toString() {
        return "Search2(id=" + this.id + ", title=" + this.title + ", excerpt=" + this.excerpt + ", url=" + this.url + ", postType=" + this.postType + ", year=" + this.year + ", rating=" + this.rating + ", image=" + this.image + ", director=" + this.director + ", cast=" + this.cast + ')';
    }

    public Search2(@JsonProperty("ID") long id, @NotNull String title, @NotNull String excerpt, @NotNull String url, @JsonProperty("post_type") @NotNull String postType, @NotNull String year, @NotNull String rating, @NotNull String image, @NotNull String director, @Nullable String cast) {
        this.id = id;
        this.title = title;
        this.excerpt = excerpt;
        this.url = url;
        this.postType = postType;
        this.year = year;
        this.rating = rating;
        this.image = image;
        this.director = director;
        this.cast = cast;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getExcerpt() {
        return this.excerpt;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getPostType() {
        return this.postType;
    }

    @NotNull
    public final String getYear() {
        return this.year;
    }

    @NotNull
    public final String getRating() {
        return this.rating;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getDirector() {
        return this.director;
    }

    @Nullable
    public final String getCast() {
        return this.cast;
    }
}
