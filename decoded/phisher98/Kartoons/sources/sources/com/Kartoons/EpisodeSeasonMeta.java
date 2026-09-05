package com.Kartoons;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kartoons/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ4\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/Kartoons/EpisodeSeasonMeta;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_id", "seasonNumber", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getId", "()Ljava/lang/String;", "getSeasonNumber", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/Kartoons/EpisodeSeasonMeta;", "equals", "", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeSeasonMeta {

    @JsonProperty("_id")
    @Nullable
    private final String id;

    @Nullable
    private final Long seasonNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public EpisodeSeasonMeta() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EpisodeSeasonMeta copy$default(EpisodeSeasonMeta episodeSeasonMeta, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episodeSeasonMeta.id;
        }
        if ((i & 2) != 0) {
            l = episodeSeasonMeta.seasonNumber;
        }
        return episodeSeasonMeta.copy(str, l);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getSeasonNumber() {
        return this.seasonNumber;
    }

    @NotNull
    public final EpisodeSeasonMeta copy(@JsonProperty("_id") @Nullable String id, @Nullable Long seasonNumber) {
        return new EpisodeSeasonMeta(id, seasonNumber);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeSeasonMeta)) {
            return false;
        }
        EpisodeSeasonMeta episodeSeasonMeta = (EpisodeSeasonMeta) other;
        return Intrinsics.areEqual(this.id, episodeSeasonMeta.id) && Intrinsics.areEqual(this.seasonNumber, episodeSeasonMeta.seasonNumber);
    }

    public int hashCode() {
        return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.seasonNumber != null ? this.seasonNumber.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeSeasonMeta(id=" + this.id + ", seasonNumber=" + this.seasonNumber + ')';
    }

    public EpisodeSeasonMeta(@JsonProperty("_id") @Nullable String id, @Nullable Long seasonNumber) {
        this.id = id;
        this.seasonNumber = seasonNumber;
    }

    public /* synthetic */ EpisodeSeasonMeta(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Long getSeasonNumber() {
        return this.seasonNumber;
    }
}
