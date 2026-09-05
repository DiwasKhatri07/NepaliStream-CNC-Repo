package com.Coflix;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Goojara/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/Coflix/EpRes;", "", "postId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "post_id", "title", "episodes", "", "Lcom/Coflix/Episode;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getPostId", "()Ljava/lang/String;", "getTitle", "getEpisodes", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Goojara"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpRes {

    @NotNull
    private final List<Episode> episodes;

    @NotNull
    private final String postId;

    @NotNull
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EpRes copy$default(EpRes epRes, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = epRes.postId;
        }
        if ((i & 2) != 0) {
            str2 = epRes.title;
        }
        if ((i & 4) != 0) {
            list = epRes.episodes;
        }
        return epRes.copy(str, str2, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPostId() {
        return this.postId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<Episode> component3() {
        return this.episodes;
    }

    @NotNull
    public final EpRes copy(@JsonProperty("post_id") @NotNull String postId, @NotNull String title, @NotNull List<Episode> episodes) {
        return new EpRes(postId, title, episodes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpRes)) {
            return false;
        }
        EpRes epRes = (EpRes) other;
        return Intrinsics.areEqual(this.postId, epRes.postId) && Intrinsics.areEqual(this.title, epRes.title) && Intrinsics.areEqual(this.episodes, epRes.episodes);
    }

    public int hashCode() {
        return (((this.postId.hashCode() * 31) + this.title.hashCode()) * 31) + this.episodes.hashCode();
    }

    @NotNull
    public String toString() {
        return "EpRes(postId=" + this.postId + ", title=" + this.title + ", episodes=" + this.episodes + ')';
    }

    public EpRes(@JsonProperty("post_id") @NotNull String postId, @NotNull String title, @NotNull List<Episode> list) {
        this.postId = postId;
        this.title = title;
        this.episodes = list;
    }

    @NotNull
    public final String getPostId() {
        return this.postId;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<Episode> getEpisodes() {
        return this.episodes;
    }
}
