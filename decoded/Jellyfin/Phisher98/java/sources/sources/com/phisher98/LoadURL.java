package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Jellyfin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u001c\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0001\u0010\b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003J?\u0010\u0013\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\b\u001a\u00020\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\tHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/phisher98/LoadURL;", "", "mediaSources", "", "Lcom/phisher98/MediaSource;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "MediaSources", "playSessionId", "", "PlaySessionId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getMediaSources", "()Ljava/util/List;", "getPlaySessionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadURL {

    @NotNull
    private final List<MediaSource> mediaSources;

    @NotNull
    private final String playSessionId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoadURL copy$default(LoadURL loadURL, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = loadURL.mediaSources;
        }
        if ((i & 2) != 0) {
            str = loadURL.playSessionId;
        }
        return loadURL.copy(list, str);
    }

    @NotNull
    public final List<MediaSource> component1() {
        return this.mediaSources;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPlaySessionId() {
        return this.playSessionId;
    }

    @NotNull
    public final LoadURL copy(@JsonProperty("MediaSources") @NotNull List<MediaSource> mediaSources, @JsonProperty("PlaySessionId") @NotNull String playSessionId) {
        return new LoadURL(mediaSources, playSessionId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadURL)) {
            return false;
        }
        LoadURL loadURL = (LoadURL) other;
        return Intrinsics.areEqual(this.mediaSources, loadURL.mediaSources) && Intrinsics.areEqual(this.playSessionId, loadURL.playSessionId);
    }

    public int hashCode() {
        return (this.mediaSources.hashCode() * 31) + this.playSessionId.hashCode();
    }

    @NotNull
    public String toString() {
        return "LoadURL(mediaSources=" + this.mediaSources + ", playSessionId=" + this.playSessionId + ')';
    }

    public LoadURL(@JsonProperty("MediaSources") @NotNull List<MediaSource> list, @JsonProperty("PlaySessionId") @NotNull String playSessionId) {
        this.mediaSources = list;
        this.playSessionId = playSessionId;
    }

    @NotNull
    public final List<MediaSource> getMediaSources() {
        return this.mediaSources;
    }

    @NotNull
    public final String getPlaySessionId() {
        return this.playSessionId;
    }
}
