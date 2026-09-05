package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/phisher98/MeteorStream;", "", "name", "", "title", "url", "behaviorHints", "Lcom/phisher98/MeteorBehaviorHints;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/MeteorBehaviorHints;)V", "getName", "()Ljava/lang/String;", "getTitle", "getUrl", "getBehaviorHints", "()Lcom/phisher98/MeteorBehaviorHints;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MeteorStream {

    @NotNull
    private final MeteorBehaviorHints behaviorHints;

    @NotNull
    private final String name;

    @NotNull
    private final String title;

    @NotNull
    private final String url;

    public static /* synthetic */ MeteorStream copy$default(MeteorStream meteorStream, String str, String str2, String str3, MeteorBehaviorHints meteorBehaviorHints, int i, Object obj) {
        if ((i & 1) != 0) {
            str = meteorStream.name;
        }
        if ((i & 2) != 0) {
            str2 = meteorStream.title;
        }
        if ((i & 4) != 0) {
            str3 = meteorStream.url;
        }
        if ((i & 8) != 0) {
            meteorBehaviorHints = meteorStream.behaviorHints;
        }
        return meteorStream.copy(str, str2, str3, meteorBehaviorHints);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MeteorBehaviorHints getBehaviorHints() {
        return this.behaviorHints;
    }

    @NotNull
    public final MeteorStream copy(@NotNull String name, @NotNull String title, @NotNull String url, @NotNull MeteorBehaviorHints behaviorHints) {
        return new MeteorStream(name, title, url, behaviorHints);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeteorStream)) {
            return false;
        }
        MeteorStream meteorStream = (MeteorStream) other;
        return Intrinsics.areEqual(this.name, meteorStream.name) && Intrinsics.areEqual(this.title, meteorStream.title) && Intrinsics.areEqual(this.url, meteorStream.url) && Intrinsics.areEqual(this.behaviorHints, meteorStream.behaviorHints);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.title.hashCode()) * 31) + this.url.hashCode()) * 31) + this.behaviorHints.hashCode();
    }

    @NotNull
    public String toString() {
        return "MeteorStream(name=" + this.name + ", title=" + this.title + ", url=" + this.url + ", behaviorHints=" + this.behaviorHints + ')';
    }

    public MeteorStream(@NotNull String name, @NotNull String title, @NotNull String url, @NotNull MeteorBehaviorHints behaviorHints) {
        this.name = name;
        this.title = title;
        this.url = url;
        this.behaviorHints = behaviorHints;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final MeteorBehaviorHints getBehaviorHints() {
        return this.behaviorHints;
    }
}
