package com.Anichi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008b\u0001\u0010\u001c\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0007\u0010\u0002¨\u0006#"}, d2 = {"Lcom/Anichi/MetaMappings;", "", "themoviedbId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "themoviedb_id", "thetvdbId", "thetvdb_id", "imdbId", "imdb_id", "malId", "mal_id", "anilistId", "anilist_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getThemoviedbId", "()Ljava/lang/String;", "getThetvdbId", "getImdbId", "getMalId", "getAnilistId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaMappings {

    @Nullable
    private final String anilistId;

    @Nullable
    private final String imdbId;

    @Nullable
    private final String malId;

    @Nullable
    private final String themoviedbId;

    @Nullable
    private final String thetvdbId;

    public MetaMappings() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MetaMappings copy$default(MetaMappings metaMappings, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metaMappings.themoviedbId;
        }
        if ((i & 2) != 0) {
            str2 = metaMappings.thetvdbId;
        }
        if ((i & 4) != 0) {
            str3 = metaMappings.imdbId;
        }
        if ((i & 8) != 0) {
            str4 = metaMappings.malId;
        }
        if ((i & 16) != 0) {
            str5 = metaMappings.anilistId;
        }
        String str6 = str5;
        String str7 = str3;
        return metaMappings.copy(str, str2, str7, str4, str6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getThemoviedbId() {
        return this.themoviedbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThetvdbId() {
        return this.thetvdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMalId() {
        return this.malId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAnilistId() {
        return this.anilistId;
    }

    @NotNull
    public final MetaMappings copy(@JsonProperty("themoviedb_id") @Nullable String themoviedbId, @JsonProperty("thetvdb_id") @Nullable String thetvdbId, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("mal_id") @Nullable String malId, @JsonProperty("anilist_id") @Nullable String anilistId) {
        return new MetaMappings(themoviedbId, thetvdbId, imdbId, malId, anilistId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaMappings)) {
            return false;
        }
        MetaMappings metaMappings = (MetaMappings) other;
        return Intrinsics.areEqual(this.themoviedbId, metaMappings.themoviedbId) && Intrinsics.areEqual(this.thetvdbId, metaMappings.thetvdbId) && Intrinsics.areEqual(this.imdbId, metaMappings.imdbId) && Intrinsics.areEqual(this.malId, metaMappings.malId) && Intrinsics.areEqual(this.anilistId, metaMappings.anilistId);
    }

    public int hashCode() {
        return ((((((((this.themoviedbId == null ? 0 : this.themoviedbId.hashCode()) * 31) + (this.thetvdbId == null ? 0 : this.thetvdbId.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.anilistId != null ? this.anilistId.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaMappings(themoviedbId=" + this.themoviedbId + ", thetvdbId=" + this.thetvdbId + ", imdbId=" + this.imdbId + ", malId=" + this.malId + ", anilistId=" + this.anilistId + ')';
    }

    public MetaMappings(@JsonProperty("themoviedb_id") @Nullable String themoviedbId, @JsonProperty("thetvdb_id") @Nullable String thetvdbId, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("mal_id") @Nullable String malId, @JsonProperty("anilist_id") @Nullable String anilistId) {
        this.themoviedbId = themoviedbId;
        this.thetvdbId = thetvdbId;
        this.imdbId = imdbId;
        this.malId = malId;
        this.anilistId = anilistId;
    }

    public /* synthetic */ MetaMappings(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    @Nullable
    public final String getThemoviedbId() {
        return this.themoviedbId;
    }

    @Nullable
    public final String getThetvdbId() {
        return this.thetvdbId;
    }

    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    public final String getMalId() {
        return this.malId;
    }

    @Nullable
    public final String getAnilistId() {
        return this.anilistId;
    }
}
