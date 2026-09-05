package com.idlix;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IdlixProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/idlix/Meta;", "", "genre", "", "country", "year", "network", "sort", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGenre", "()Ljava/lang/String;", "getCountry", "getYear", "getNetwork", "getSort", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Meta {

    @Nullable
    private final String country;

    @Nullable
    private final String genre;

    @Nullable
    private final String network;

    @Nullable
    private final String sort;

    @Nullable
    private final String year;

    public Meta() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Meta copy$default(Meta meta, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = meta.genre;
        }
        if ((i & 2) != 0) {
            str2 = meta.country;
        }
        if ((i & 4) != 0) {
            str3 = meta.year;
        }
        if ((i & 8) != 0) {
            str4 = meta.network;
        }
        if ((i & 16) != 0) {
            str5 = meta.sort;
        }
        String str6 = str5;
        String str7 = str3;
        return meta.copy(str, str2, str7, str4, str6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGenre() {
        return this.genre;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNetwork() {
        return this.network;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSort() {
        return this.sort;
    }

    @NotNull
    public final Meta copy(@Nullable String genre, @Nullable String country, @Nullable String year, @Nullable String network, @Nullable String sort) {
        return new Meta(genre, country, year, network, sort);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Meta)) {
            return false;
        }
        Meta meta = (Meta) other;
        return Intrinsics.areEqual(this.genre, meta.genre) && Intrinsics.areEqual(this.country, meta.country) && Intrinsics.areEqual(this.year, meta.year) && Intrinsics.areEqual(this.network, meta.network) && Intrinsics.areEqual(this.sort, meta.sort);
    }

    public int hashCode() {
        return ((((((((this.genre == null ? 0 : this.genre.hashCode()) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.network == null ? 0 : this.network.hashCode())) * 31) + (this.sort != null ? this.sort.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Meta(genre=" + this.genre + ", country=" + this.country + ", year=" + this.year + ", network=" + this.network + ", sort=" + this.sort + ')';
    }

    public Meta(@Nullable String genre, @Nullable String country, @Nullable String year, @Nullable String network, @Nullable String sort) {
        this.genre = genre;
        this.country = country;
        this.year = year;
        this.network = network;
        this.sort = sort;
    }

    public /* synthetic */ Meta(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    @Nullable
    public final String getGenre() {
        return this.genre;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getYear() {
        return this.year;
    }

    @Nullable
    public final String getNetwork() {
        return this.network;
    }

    @Nullable
    public final String getSort() {
        return this.sort;
    }
}
