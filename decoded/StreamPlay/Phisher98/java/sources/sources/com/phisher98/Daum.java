package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0004\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0014\u001a\u00020\f:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J§\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0003\u0010\u0004\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\u0016\b\u0003\u0010\u0014\u001a\u00020\f:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015HÆ\u0001J\u0014\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020\tHÖ\u0081\u0004J\n\u0010:\u001a\u00020\fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001f¨\u0006;"}, d2 = {"Lcom/phisher98/Daum;", "", "id", "", "animeId", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "anime_id", "episode", "", "episode2", "edition", "", "title", "snapshot", "disc", "audio", "duration", "session", "filler", "createdAt", "created_at", "<init>", "(JJIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()J", "getAnimeId", "getEpisode", "()I", "getEpisode2", "getEdition", "()Ljava/lang/String;", "getTitle", "getSnapshot", "getDisc", "getAudio", "getDuration", "getSession", "getFiller", "getCreatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Daum {
    private final long animeId;

    @NotNull
    private final String audio;

    @NotNull
    private final String createdAt;

    @NotNull
    private final String disc;

    @NotNull
    private final String duration;

    @NotNull
    private final String edition;
    private final int episode;
    private final long episode2;
    private final long filler;
    private final long id;

    @NotNull
    private final String session;

    @NotNull
    private final String snapshot;

    @NotNull
    private final String title;

    public static /* synthetic */ Daum copy$default(Daum daum, long j, long j2, int i, long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j4, String str8, int i2, Object obj) {
        long j5 = (i2 & 1) != 0 ? daum.id : j;
        return daum.copy(j5, (i2 & 2) != 0 ? daum.animeId : j2, (i2 & 4) != 0 ? daum.episode : i, (i2 & 8) != 0 ? daum.episode2 : j3, (i2 & 16) != 0 ? daum.edition : str, (i2 & 32) != 0 ? daum.title : str2, (i2 & 64) != 0 ? daum.snapshot : str3, (i2 & 128) != 0 ? daum.disc : str4, (i2 & 256) != 0 ? daum.audio : str5, (i2 & 512) != 0 ? daum.duration : str6, (i2 & 1024) != 0 ? daum.session : str7, (i2 & 2048) != 0 ? daum.filler : j4, (i2 & 4096) != 0 ? daum.createdAt : str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getFiller() {
        return this.filler;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getAnimeId() {
        return this.animeId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getEpisode() {
        return this.episode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getEpisode2() {
        return this.episode2;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEdition() {
        return this.edition;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSnapshot() {
        return this.snapshot;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDisc() {
        return this.disc;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAudio() {
        return this.audio;
    }

    @NotNull
    public final Daum copy(long id, @JsonProperty("anime_id") long animeId, int episode, long episode2, @NotNull String edition, @NotNull String title, @NotNull String snapshot, @NotNull String disc, @NotNull String audio, @NotNull String duration, @NotNull String session, long filler, @JsonProperty("created_at") @NotNull String createdAt) {
        return new Daum(id, animeId, episode, episode2, edition, title, snapshot, disc, audio, duration, session, filler, createdAt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Daum)) {
            return false;
        }
        Daum daum = (Daum) other;
        return this.id == daum.id && this.animeId == daum.animeId && this.episode == daum.episode && this.episode2 == daum.episode2 && Intrinsics.areEqual(this.edition, daum.edition) && Intrinsics.areEqual(this.title, daum.title) && Intrinsics.areEqual(this.snapshot, daum.snapshot) && Intrinsics.areEqual(this.disc, daum.disc) && Intrinsics.areEqual(this.audio, daum.audio) && Intrinsics.areEqual(this.duration, daum.duration) && Intrinsics.areEqual(this.session, daum.session) && this.filler == daum.filler && Intrinsics.areEqual(this.createdAt, daum.createdAt);
    }

    public int hashCode() {
        return (((((((((((((((((((((((Daum$$ExternalSyntheticBackport0.m12m(this.id) * 31) + Daum$$ExternalSyntheticBackport0.m12m(this.animeId)) * 31) + this.episode) * 31) + Daum$$ExternalSyntheticBackport0.m12m(this.episode2)) * 31) + this.edition.hashCode()) * 31) + this.title.hashCode()) * 31) + this.snapshot.hashCode()) * 31) + this.disc.hashCode()) * 31) + this.audio.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.session.hashCode()) * 31) + Daum$$ExternalSyntheticBackport0.m12m(this.filler)) * 31) + this.createdAt.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Daum(id=").append(this.id).append(", animeId=").append(this.animeId).append(", episode=").append(this.episode).append(", episode2=").append(this.episode2).append(", edition=").append(this.edition).append(", title=").append(this.title).append(", snapshot=").append(this.snapshot).append(", disc=").append(this.disc).append(", audio=").append(this.audio).append(", duration=").append(this.duration).append(", session=").append(this.session).append(", filler=");
        sb.append(this.filler).append(", createdAt=").append(this.createdAt).append(')');
        return sb.toString();
    }

    public Daum(long id, @JsonProperty("anime_id") long animeId, int episode, long episode2, @NotNull String edition, @NotNull String title, @NotNull String snapshot, @NotNull String disc, @NotNull String audio, @NotNull String duration, @NotNull String session, long filler, @JsonProperty("created_at") @NotNull String createdAt) {
        this.id = id;
        this.animeId = animeId;
        this.episode = episode;
        this.episode2 = episode2;
        this.edition = edition;
        this.title = title;
        this.snapshot = snapshot;
        this.disc = disc;
        this.audio = audio;
        this.duration = duration;
        this.session = session;
        this.filler = filler;
        this.createdAt = createdAt;
    }

    public final long getId() {
        return this.id;
    }

    public final long getAnimeId() {
        return this.animeId;
    }

    public final int getEpisode() {
        return this.episode;
    }

    public final long getEpisode2() {
        return this.episode2;
    }

    @NotNull
    public final String getEdition() {
        return this.edition;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getSnapshot() {
        return this.snapshot;
    }

    @NotNull
    public final String getDisc() {
        return this.disc;
    }

    @NotNull
    public final String getAudio() {
        return this.audio;
    }

    @NotNull
    public final String getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getSession() {
        return this.session;
    }

    public final long getFiller() {
        return this.filler;
    }

    @NotNull
    public final String getCreatedAt() {
        return this.createdAt;
    }
}
