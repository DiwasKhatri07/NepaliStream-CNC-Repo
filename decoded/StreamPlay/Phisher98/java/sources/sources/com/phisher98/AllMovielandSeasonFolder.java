package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012*\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003Ji\u0010\u0015\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062*\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/phisher98/AllMovielandSeasonFolder;", "", "episode", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "id", "folder", "Ljava/util/ArrayList;", "Lcom/phisher98/AllMovielandEpisodeFolder;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getEpisode", "()Ljava/lang/String;", "getId", "getFolder", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AllMovielandSeasonFolder {

    @Nullable
    private final String episode;

    @Nullable
    private final ArrayList<AllMovielandEpisodeFolder> folder;

    @Nullable
    private final String id;

    public AllMovielandSeasonFolder() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AllMovielandSeasonFolder copy$default(AllMovielandSeasonFolder allMovielandSeasonFolder, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = allMovielandSeasonFolder.episode;
        }
        if ((i & 2) != 0) {
            str2 = allMovielandSeasonFolder.id;
        }
        if ((i & 4) != 0) {
            arrayList = allMovielandSeasonFolder.folder;
        }
        return allMovielandSeasonFolder.copy(str, str2, arrayList);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEpisode() {
        return this.episode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final ArrayList<AllMovielandEpisodeFolder> component3() {
        return this.folder;
    }

    @NotNull
    public final AllMovielandSeasonFolder copy(@JsonProperty("episode") @Nullable String episode, @JsonProperty("id") @Nullable String id, @JsonProperty("folder") @Nullable ArrayList<AllMovielandEpisodeFolder> folder) {
        return new AllMovielandSeasonFolder(episode, id, folder);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AllMovielandSeasonFolder)) {
            return false;
        }
        AllMovielandSeasonFolder allMovielandSeasonFolder = (AllMovielandSeasonFolder) other;
        return Intrinsics.areEqual(this.episode, allMovielandSeasonFolder.episode) && Intrinsics.areEqual(this.id, allMovielandSeasonFolder.id) && Intrinsics.areEqual(this.folder, allMovielandSeasonFolder.folder);
    }

    public int hashCode() {
        return ((((this.episode == null ? 0 : this.episode.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.folder != null ? this.folder.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AllMovielandSeasonFolder(episode=" + this.episode + ", id=" + this.id + ", folder=" + this.folder + ')';
    }

    public AllMovielandSeasonFolder(@JsonProperty("episode") @Nullable String episode, @JsonProperty("id") @Nullable String id, @JsonProperty("folder") @Nullable ArrayList<AllMovielandEpisodeFolder> arrayList) {
        this.episode = episode;
        this.id = id;
        this.folder = arrayList;
    }

    public /* synthetic */ AllMovielandSeasonFolder(String str, String str2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? new ArrayList() : arrayList);
    }

    @Nullable
    public final String getEpisode() {
        return this.episode;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final ArrayList<AllMovielandEpisodeFolder> getFolder() {
        return this.folder;
    }
}
