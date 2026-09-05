package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Jellyfin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017Jv\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\bHÖ\u0081\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\n\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017¨\u0006%"}, d2 = {"Lcom/phisher98/UserData;", "", "playbackPositionTicks", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "PlaybackPositionTicks", "playCount", "", "PlayCount", "isFavorite", "", "IsFavorite", "played", "Played", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getPlaybackPositionTicks", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPlayCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPlayed", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/phisher98/UserData;", "equals", "other", "hashCode", "toString", "", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class UserData {

    @Nullable
    private final Boolean isFavorite;

    @Nullable
    private final Integer playCount;

    @Nullable
    private final Long playbackPositionTicks;

    @Nullable
    private final Boolean played;

    public UserData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ UserData copy$default(UserData userData, Long l, Integer num, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = userData.playbackPositionTicks;
        }
        if ((i & 2) != 0) {
            num = userData.playCount;
        }
        if ((i & 4) != 0) {
            bool = userData.isFavorite;
        }
        if ((i & 8) != 0) {
            bool2 = userData.played;
        }
        return userData.copy(l, num, bool, bool2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getPlaybackPositionTicks() {
        return this.playbackPositionTicks;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getPlayCount() {
        return this.playCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getIsFavorite() {
        return this.isFavorite;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getPlayed() {
        return this.played;
    }

    @NotNull
    public final UserData copy(@JsonProperty("PlaybackPositionTicks") @Nullable Long playbackPositionTicks, @JsonProperty("PlayCount") @Nullable Integer playCount, @JsonProperty("IsFavorite") @Nullable Boolean isFavorite, @JsonProperty("Played") @Nullable Boolean played) {
        return new UserData(playbackPositionTicks, playCount, isFavorite, played);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserData)) {
            return false;
        }
        UserData userData = (UserData) other;
        return Intrinsics.areEqual(this.playbackPositionTicks, userData.playbackPositionTicks) && Intrinsics.areEqual(this.playCount, userData.playCount) && Intrinsics.areEqual(this.isFavorite, userData.isFavorite) && Intrinsics.areEqual(this.played, userData.played);
    }

    public int hashCode() {
        return ((((((this.playbackPositionTicks == null ? 0 : this.playbackPositionTicks.hashCode()) * 31) + (this.playCount == null ? 0 : this.playCount.hashCode())) * 31) + (this.isFavorite == null ? 0 : this.isFavorite.hashCode())) * 31) + (this.played != null ? this.played.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "UserData(playbackPositionTicks=" + this.playbackPositionTicks + ", playCount=" + this.playCount + ", isFavorite=" + this.isFavorite + ", played=" + this.played + ')';
    }

    public UserData(@JsonProperty("PlaybackPositionTicks") @Nullable Long playbackPositionTicks, @JsonProperty("PlayCount") @Nullable Integer playCount, @JsonProperty("IsFavorite") @Nullable Boolean isFavorite, @JsonProperty("Played") @Nullable Boolean played) {
        this.playbackPositionTicks = playbackPositionTicks;
        this.playCount = playCount;
        this.isFavorite = isFavorite;
        this.played = played;
    }

    public /* synthetic */ UserData(Long l, Integer num, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2);
    }

    @Nullable
    public final Long getPlaybackPositionTicks() {
        return this.playbackPositionTicks;
    }

    @Nullable
    public final Integer getPlayCount() {
        return this.playCount;
    }

    @Nullable
    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    @Nullable
    public final Boolean getPlayed() {
        return this.played;
    }
}
