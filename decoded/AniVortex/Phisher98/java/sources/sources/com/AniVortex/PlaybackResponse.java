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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u001e\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0096\u0001\u0010$\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u001e\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010HÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010*\u001a\u00020\nHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R'\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R'\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR-\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR'\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eÊ\u0001\f\b,\u0012\b\b-\u0012\u0004\b\u0007\u0010\u0002¨\u0006+"}, d2 = {"Lcom/AniVortex/PlaybackResponse;", "", "titleId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title_id", "episode", "Lcom/AniVortex/EpisodeRef;", "selectedServerKey", "", "selected_server_key", "serverOptions", "", "Lcom/AniVortex/ServerOption;", "server_options", "server", "Lcom/AniVortex/PlaybackServer;", "<init>", "(Ljava/lang/Integer;Lcom/AniVortex/EpisodeRef;Ljava/lang/String;Ljava/util/List;Lcom/AniVortex/PlaybackServer;)V", "getTitleId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "()Lcom/AniVortex/EpisodeRef;", "getSelectedServerKey", "()Ljava/lang/String;", "getServerOptions", "()Ljava/util/List;", "getServer", "()Lcom/AniVortex/PlaybackServer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Lcom/AniVortex/EpisodeRef;Ljava/lang/String;Ljava/util/List;Lcom/AniVortex/PlaybackServer;)Lcom/AniVortex/PlaybackResponse;", "equals", "", "other", "hashCode", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PlaybackResponse {

    @JsonProperty("episode")
    @Nullable
    private final EpisodeRef episode;

    @JsonProperty("selected_server_key")
    @Nullable
    private final String selectedServerKey;

    @JsonProperty("server")
    @Nullable
    private final PlaybackServer server;

    @JsonProperty("server_options")
    @Nullable
    private final List<ServerOption> serverOptions;

    @JsonProperty("title_id")
    @Nullable
    private final Integer titleId;

    public PlaybackResponse() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaybackResponse copy$default(PlaybackResponse playbackResponse, Integer num, EpisodeRef episodeRef, String str, List list, PlaybackServer playbackServer, int i, Object obj) {
        if ((i & 1) != 0) {
            num = playbackResponse.titleId;
        }
        if ((i & 2) != 0) {
            episodeRef = playbackResponse.episode;
        }
        if ((i & 4) != 0) {
            str = playbackResponse.selectedServerKey;
        }
        if ((i & 8) != 0) {
            list = playbackResponse.serverOptions;
        }
        if ((i & 16) != 0) {
            playbackServer = playbackResponse.server;
        }
        PlaybackServer playbackServer2 = playbackServer;
        String str2 = str;
        return playbackResponse.copy(num, episodeRef, str2, list, playbackServer2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTitleId() {
        return this.titleId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EpisodeRef getEpisode() {
        return this.episode;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSelectedServerKey() {
        return this.selectedServerKey;
    }

    @Nullable
    public final List<ServerOption> component4() {
        return this.serverOptions;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PlaybackServer getServer() {
        return this.server;
    }

    @NotNull
    public final PlaybackResponse copy(@JsonProperty("title_id") @Nullable Integer titleId, @JsonProperty("episode") @Nullable EpisodeRef episode, @JsonProperty("selected_server_key") @Nullable String selectedServerKey, @JsonProperty("server_options") @Nullable List<ServerOption> serverOptions, @JsonProperty("server") @Nullable PlaybackServer server) {
        return new PlaybackResponse(titleId, episode, selectedServerKey, serverOptions, server);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaybackResponse)) {
            return false;
        }
        PlaybackResponse playbackResponse = (PlaybackResponse) other;
        return Intrinsics.areEqual(this.titleId, playbackResponse.titleId) && Intrinsics.areEqual(this.episode, playbackResponse.episode) && Intrinsics.areEqual(this.selectedServerKey, playbackResponse.selectedServerKey) && Intrinsics.areEqual(this.serverOptions, playbackResponse.serverOptions) && Intrinsics.areEqual(this.server, playbackResponse.server);
    }

    public int hashCode() {
        return ((((((((this.titleId == null ? 0 : this.titleId.hashCode()) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.selectedServerKey == null ? 0 : this.selectedServerKey.hashCode())) * 31) + (this.serverOptions == null ? 0 : this.serverOptions.hashCode())) * 31) + (this.server != null ? this.server.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlaybackResponse(titleId=" + this.titleId + ", episode=" + this.episode + ", selectedServerKey=" + this.selectedServerKey + ", serverOptions=" + this.serverOptions + ", server=" + this.server + ')';
    }

    public PlaybackResponse(@JsonProperty("title_id") @Nullable Integer titleId, @JsonProperty("episode") @Nullable EpisodeRef episode, @JsonProperty("selected_server_key") @Nullable String selectedServerKey, @JsonProperty("server_options") @Nullable List<ServerOption> list, @JsonProperty("server") @Nullable PlaybackServer server) {
        this.titleId = titleId;
        this.episode = episode;
        this.selectedServerKey = selectedServerKey;
        this.serverOptions = list;
        this.server = server;
    }

    public /* synthetic */ PlaybackResponse(Integer num, EpisodeRef episodeRef, String str, List list, PlaybackServer playbackServer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : episodeRef, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : playbackServer);
    }

    @Nullable
    public final Integer getTitleId() {
        return this.titleId;
    }

    @Nullable
    public final EpisodeRef getEpisode() {
        return this.episode;
    }

    @Nullable
    public final String getSelectedServerKey() {
        return this.selectedServerKey;
    }

    @Nullable
    public final List<ServerOption> getServerOptions() {
        return this.serverOptions;
    }

    @Nullable
    public final PlaybackServer getServer() {
        return this.server;
    }
}
