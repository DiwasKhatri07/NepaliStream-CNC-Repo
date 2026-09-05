package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R%\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR%\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/phisher98/LastEpisodeToAir;", "", "episode_number", "", "season_number", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEpisode_number", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getSeason_number", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/LastEpisodeToAir;", "equals", "", "other", "hashCode", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LastEpisodeToAir {

    @Nullable
    private final Integer episode_number;

    @Nullable
    private final Integer season_number;

    /* JADX WARN: Illegal instructions before constructor call */
    public LastEpisodeToAir() {
        Integer num = null;
        this(num, num, 3, num);
    }

    public static /* synthetic */ LastEpisodeToAir copy$default(LastEpisodeToAir lastEpisodeToAir, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = lastEpisodeToAir.episode_number;
        }
        if ((i & 2) != 0) {
            num2 = lastEpisodeToAir.season_number;
        }
        return lastEpisodeToAir.copy(num, num2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getEpisode_number() {
        return this.episode_number;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSeason_number() {
        return this.season_number;
    }

    @NotNull
    public final LastEpisodeToAir copy(@Nullable Integer episode_number, @Nullable Integer season_number) {
        return new LastEpisodeToAir(episode_number, season_number);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LastEpisodeToAir)) {
            return false;
        }
        LastEpisodeToAir lastEpisodeToAir = (LastEpisodeToAir) other;
        return Intrinsics.areEqual(this.episode_number, lastEpisodeToAir.episode_number) && Intrinsics.areEqual(this.season_number, lastEpisodeToAir.season_number);
    }

    public int hashCode() {
        return ((this.episode_number == null ? 0 : this.episode_number.hashCode()) * 31) + (this.season_number != null ? this.season_number.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LastEpisodeToAir(episode_number=" + this.episode_number + ", season_number=" + this.season_number + ')';
    }

    public LastEpisodeToAir(@Nullable Integer episode_number, @Nullable Integer season_number) {
        this.episode_number = episode_number;
        this.season_number = season_number;
    }

    public /* synthetic */ LastEpisodeToAir(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    @JsonProperty("episode_number")
    @Nullable
    public final Integer getEpisode_number() {
        return this.episode_number;
    }

    @JsonProperty("season_number")
    @Nullable
    public final Integer getSeason_number() {
        return this.season_number;
    }
}
