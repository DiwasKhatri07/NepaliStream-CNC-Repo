package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/AnichiEP;", "", "data", "Lcom/phisher98/AnichiEPData;", "episode", "Lcom/phisher98/AnichiEpisode;", "<init>", "(Lcom/phisher98/AnichiEPData;Lcom/phisher98/AnichiEpisode;)V", "getData", "()Lcom/phisher98/AnichiEPData;", "getEpisode", "()Lcom/phisher98/AnichiEpisode;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiEP {

    @Nullable
    private final AnichiEPData data;

    @Nullable
    private final AnichiEpisode episode;

    /* JADX WARN: Multi-variable type inference failed */
    public AnichiEP() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnichiEP copy$default(AnichiEP anichiEP, AnichiEPData anichiEPData, AnichiEpisode anichiEpisode, int i, Object obj) {
        if ((i & 1) != 0) {
            anichiEPData = anichiEP.data;
        }
        if ((i & 2) != 0) {
            anichiEpisode = anichiEP.episode;
        }
        return anichiEP.copy(anichiEPData, anichiEpisode);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AnichiEPData getData() {
        return this.data;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AnichiEpisode getEpisode() {
        return this.episode;
    }

    @NotNull
    public final AnichiEP copy(@Nullable AnichiEPData data, @Nullable AnichiEpisode episode) {
        return new AnichiEP(data, episode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnichiEP)) {
            return false;
        }
        AnichiEP anichiEP = (AnichiEP) other;
        return Intrinsics.areEqual(this.data, anichiEP.data) && Intrinsics.areEqual(this.episode, anichiEP.episode);
    }

    public int hashCode() {
        return ((this.data == null ? 0 : this.data.hashCode()) * 31) + (this.episode != null ? this.episode.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnichiEP(data=" + this.data + ", episode=" + this.episode + ')';
    }

    public AnichiEP(@Nullable AnichiEPData data, @Nullable AnichiEpisode episode) {
        this.data = data;
        this.episode = episode;
    }

    public /* synthetic */ AnichiEP(AnichiEPData anichiEPData, AnichiEpisode anichiEpisode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : anichiEPData, (i & 2) != 0 ? null : anichiEpisode);
    }

    @Nullable
    public final AnichiEPData getData() {
        return this.data;
    }

    @Nullable
    public final AnichiEpisode getEpisode() {
        return this.episode;
    }
}
