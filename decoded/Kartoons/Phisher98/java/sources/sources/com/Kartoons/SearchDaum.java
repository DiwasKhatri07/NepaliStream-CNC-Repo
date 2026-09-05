package com.Kartoons;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/Kartoons/SearchDaum;", "", "id", "", "title", "image", "year", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getImage", "getYear", "()J", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SearchDaum {

    @NotNull
    private final String id;

    @NotNull
    private final String image;

    @NotNull
    private final String title;

    @NotNull
    private final String type;
    private final long year;

    public static /* synthetic */ SearchDaum copy$default(SearchDaum searchDaum, String str, String str2, String str3, long j, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchDaum.id;
        }
        if ((i & 2) != 0) {
            str2 = searchDaum.title;
        }
        if ((i & 4) != 0) {
            str3 = searchDaum.image;
        }
        if ((i & 8) != 0) {
            j = searchDaum.year;
        }
        if ((i & 16) != 0) {
            str4 = searchDaum.type;
        }
        String str5 = str4;
        String str6 = str3;
        return searchDaum.copy(str, str2, str6, j, str5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getYear() {
        return this.year;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final SearchDaum copy(@NotNull String id, @NotNull String title, @NotNull String image, long year, @NotNull String type) {
        return new SearchDaum(id, title, image, year, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchDaum)) {
            return false;
        }
        SearchDaum searchDaum = (SearchDaum) other;
        return Intrinsics.areEqual(this.id, searchDaum.id) && Intrinsics.areEqual(this.title, searchDaum.title) && Intrinsics.areEqual(this.image, searchDaum.image) && this.year == searchDaum.year && Intrinsics.areEqual(this.type, searchDaum.type);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.image.hashCode()) * 31) + SearchDaum$$ExternalSyntheticBackport0.m3m(this.year)) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchDaum(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", year=" + this.year + ", type=" + this.type + ')';
    }

    public SearchDaum(@NotNull String id, @NotNull String title, @NotNull String image, long year, @NotNull String type) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.year = year;
        this.type = type;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    public final long getYear() {
        return this.year;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
