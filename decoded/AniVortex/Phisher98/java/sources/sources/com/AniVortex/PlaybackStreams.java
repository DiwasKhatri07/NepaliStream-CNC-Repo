package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R-\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nÊ\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/AniVortex/PlaybackStreams;", "", "qualities", "", "Lcom/AniVortex/QualityStream;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getQualities", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PlaybackStreams {

    @JsonProperty("qualities")
    @Nullable
    private final List<QualityStream> qualities;

    /* JADX WARN: Illegal instructions before constructor call */
    public PlaybackStreams() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaybackStreams copy$default(PlaybackStreams playbackStreams, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = playbackStreams.qualities;
        }
        return playbackStreams.copy(list);
    }

    @Nullable
    public final List<QualityStream> component1() {
        return this.qualities;
    }

    @NotNull
    public final PlaybackStreams copy(@JsonProperty("qualities") @Nullable List<QualityStream> qualities) {
        return new PlaybackStreams(qualities);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PlaybackStreams) && Intrinsics.areEqual(this.qualities, ((PlaybackStreams) other).qualities);
    }

    public int hashCode() {
        if (this.qualities == null) {
            return 0;
        }
        return this.qualities.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlaybackStreams(qualities=" + this.qualities + ')';
    }

    public PlaybackStreams(@JsonProperty("qualities") @Nullable List<QualityStream> list) {
        this.qualities = list;
    }

    public /* synthetic */ PlaybackStreams(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    @Nullable
    public final List<QualityStream> getQualities() {
        return this.qualities;
    }
}
