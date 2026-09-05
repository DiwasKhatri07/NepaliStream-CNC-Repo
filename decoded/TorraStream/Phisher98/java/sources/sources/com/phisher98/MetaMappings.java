package com.phisher98;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jª\u0001\u0010#\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011HÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\bHÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015Ê\u0001\f\b+\u0012\b\b,\u0012\u0004\b\u0007\u0010\u0002¨\u0006*"}, d2 = {"Lcom/phisher98/MetaMappings;", "", "themoviedbId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "themoviedb_id", "thetvdbId", "", "thetvdb_id", "imdbId", "imdb_id", "malId", "mal_id", "anilistId", "anilist_id", "kitsuid", "kitsu_id", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getThemoviedbId", "()Ljava/lang/String;", "getThetvdbId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdbId", "getMalId", "getAnilistId", "getKitsuid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/MetaMappings;", "equals", "", "other", "hashCode", "toString", "TorraStream", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaMappings {

    @Nullable
    private final Integer anilistId;

    @Nullable
    private final String imdbId;

    @Nullable
    private final String kitsuid;

    @Nullable
    private final Integer malId;

    @Nullable
    private final String themoviedbId;

    @Nullable
    private final Integer thetvdbId;

    public MetaMappings() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MetaMappings copy$default(MetaMappings metaMappings, String str, Integer num, String str2, Integer num2, Integer num3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metaMappings.themoviedbId;
        }
        if ((i & 2) != 0) {
            num = metaMappings.thetvdbId;
        }
        if ((i & 4) != 0) {
            str2 = metaMappings.imdbId;
        }
        if ((i & 8) != 0) {
            num2 = metaMappings.malId;
        }
        if ((i & 16) != 0) {
            num3 = metaMappings.anilistId;
        }
        if ((i & 32) != 0) {
            str3 = metaMappings.kitsuid;
        }
        Integer num4 = num3;
        String str4 = str3;
        return metaMappings.copy(str, num, str2, num2, num4, str4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getThemoviedbId() {
        return this.themoviedbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getThetvdbId() {
        return this.thetvdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getMalId() {
        return this.malId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getAnilistId() {
        return this.anilistId;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getKitsuid() {
        return this.kitsuid;
    }

    @NotNull
    public final MetaMappings copy(@JsonProperty("themoviedb_id") @Nullable String themoviedbId, @JsonProperty("thetvdb_id") @Nullable Integer thetvdbId, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("mal_id") @Nullable Integer malId, @JsonProperty("anilist_id") @Nullable Integer anilistId, @JsonProperty("kitsu_id") @Nullable String kitsuid) {
        return new MetaMappings(themoviedbId, thetvdbId, imdbId, malId, anilistId, kitsuid);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaMappings)) {
            return false;
        }
        MetaMappings metaMappings = (MetaMappings) other;
        return Intrinsics.areEqual(this.themoviedbId, metaMappings.themoviedbId) && Intrinsics.areEqual(this.thetvdbId, metaMappings.thetvdbId) && Intrinsics.areEqual(this.imdbId, metaMappings.imdbId) && Intrinsics.areEqual(this.malId, metaMappings.malId) && Intrinsics.areEqual(this.anilistId, metaMappings.anilistId) && Intrinsics.areEqual(this.kitsuid, metaMappings.kitsuid);
    }

    public int hashCode() {
        return ((((((((((this.themoviedbId == null ? 0 : this.themoviedbId.hashCode()) * 31) + (this.thetvdbId == null ? 0 : this.thetvdbId.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.anilistId == null ? 0 : this.anilistId.hashCode())) * 31) + (this.kitsuid != null ? this.kitsuid.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaMappings(themoviedbId=" + this.themoviedbId + ", thetvdbId=" + this.thetvdbId + ", imdbId=" + this.imdbId + ", malId=" + this.malId + ", anilistId=" + this.anilistId + ", kitsuid=" + this.kitsuid + ')';
    }

    public MetaMappings(@JsonProperty("themoviedb_id") @Nullable String themoviedbId, @JsonProperty("thetvdb_id") @Nullable Integer thetvdbId, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("mal_id") @Nullable Integer malId, @JsonProperty("anilist_id") @Nullable Integer anilistId, @JsonProperty("kitsu_id") @Nullable String kitsuid) {
        this.themoviedbId = themoviedbId;
        this.thetvdbId = thetvdbId;
        this.imdbId = imdbId;
        this.malId = malId;
        this.anilistId = anilistId;
        this.kitsuid = kitsuid;
    }

    public /* synthetic */ MetaMappings(String str, Integer num, String str2, Integer num2, Integer num3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : str3);
    }

    @Nullable
    public final String getThemoviedbId() {
        return this.themoviedbId;
    }

    @Nullable
    public final Integer getThetvdbId() {
        return this.thetvdbId;
    }

    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    public final Integer getMalId() {
        return this.malId;
    }

    @Nullable
    public final Integer getAnilistId() {
        return this.anilistId;
    }

    @Nullable
    public final String getKitsuid() {
        return this.kitsuid;
    }
}
