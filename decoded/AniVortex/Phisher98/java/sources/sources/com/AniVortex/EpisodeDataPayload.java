package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0015\u001a\u00020\nHÆ\u0003JZ\u0010\u0016\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR%\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u001d"}, d2 = {"Lcom/AniVortex/EpisodeDataPayload;", "", "titleId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title_id", "episodeId", "episode_id", "isMovie", "", "is_movie", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "getTitleId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisodeId", "()Z", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/AniVortex/EpisodeDataPayload;", "equals", "other", "hashCode", "toString", "", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeDataPayload {

    @JsonProperty("episode_id")
    @Nullable
    private final Integer episodeId;

    @JsonProperty("is_movie")
    private final boolean isMovie;

    @JsonProperty("title_id")
    @Nullable
    private final Integer titleId;

    public EpisodeDataPayload() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ EpisodeDataPayload copy$default(EpisodeDataPayload episodeDataPayload, Integer num, Integer num2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            num = episodeDataPayload.titleId;
        }
        if ((i & 2) != 0) {
            num2 = episodeDataPayload.episodeId;
        }
        if ((i & 4) != 0) {
            z = episodeDataPayload.isMovie;
        }
        return episodeDataPayload.copy(num, num2, z);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTitleId() {
        return this.titleId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getEpisodeId() {
        return this.episodeId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsMovie() {
        return this.isMovie;
    }

    @NotNull
    public final EpisodeDataPayload copy(@JsonProperty("title_id") @Nullable Integer titleId, @JsonProperty("episode_id") @Nullable Integer episodeId, @JsonProperty("is_movie") boolean isMovie) {
        return new EpisodeDataPayload(titleId, episodeId, isMovie);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeDataPayload)) {
            return false;
        }
        EpisodeDataPayload episodeDataPayload = (EpisodeDataPayload) other;
        return Intrinsics.areEqual(this.titleId, episodeDataPayload.titleId) && Intrinsics.areEqual(this.episodeId, episodeDataPayload.episodeId) && this.isMovie == episodeDataPayload.isMovie;
    }

    public int hashCode() {
        return ((((this.titleId == null ? 0 : this.titleId.hashCode()) * 31) + (this.episodeId != null ? this.episodeId.hashCode() : 0)) * 31) + EpisodeDataPayload$$ExternalSyntheticBackport0.m0m(this.isMovie);
    }

    @NotNull
    public String toString() {
        return "EpisodeDataPayload(titleId=" + this.titleId + ", episodeId=" + this.episodeId + ", isMovie=" + this.isMovie + ')';
    }

    public EpisodeDataPayload(@JsonProperty("title_id") @Nullable Integer titleId, @JsonProperty("episode_id") @Nullable Integer episodeId, @JsonProperty("is_movie") boolean isMovie) {
        this.titleId = titleId;
        this.episodeId = episodeId;
        this.isMovie = isMovie;
    }

    public /* synthetic */ EpisodeDataPayload(Integer num, Integer num2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? false : z);
    }

    @Nullable
    public final Integer getTitleId() {
        return this.titleId;
    }

    @Nullable
    public final Integer getEpisodeId() {
        return this.episodeId;
    }

    public final boolean isMovie() {
        return this.isMovie;
    }
}
