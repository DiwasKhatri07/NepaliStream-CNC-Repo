package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/phisher98/AIODebianStream;", "", "name", "", "description", "url", "behaviorHints", "Lcom/phisher98/AIODebianBehaviorHints;", "streamData", "Lcom/phisher98/AIODebianStreamData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/AIODebianBehaviorHints;Lcom/phisher98/AIODebianStreamData;)V", "getName", "()Ljava/lang/String;", "getDescription", "getUrl", "getBehaviorHints", "()Lcom/phisher98/AIODebianBehaviorHints;", "getStreamData", "()Lcom/phisher98/AIODebianStreamData;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AIODebianStream {

    @Nullable
    private final AIODebianBehaviorHints behaviorHints;

    @Nullable
    private final String description;

    @Nullable
    private final String name;

    @Nullable
    private final AIODebianStreamData streamData;

    @Nullable
    private final String url;

    public AIODebianStream() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ AIODebianStream copy$default(AIODebianStream aIODebianStream, String str, String str2, String str3, AIODebianBehaviorHints aIODebianBehaviorHints, AIODebianStreamData aIODebianStreamData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aIODebianStream.name;
        }
        if ((i & 2) != 0) {
            str2 = aIODebianStream.description;
        }
        if ((i & 4) != 0) {
            str3 = aIODebianStream.url;
        }
        if ((i & 8) != 0) {
            aIODebianBehaviorHints = aIODebianStream.behaviorHints;
        }
        if ((i & 16) != 0) {
            aIODebianStreamData = aIODebianStream.streamData;
        }
        AIODebianStreamData aIODebianStreamData2 = aIODebianStreamData;
        String str4 = str3;
        return aIODebianStream.copy(str, str2, str4, aIODebianBehaviorHints, aIODebianStreamData2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AIODebianBehaviorHints getBehaviorHints() {
        return this.behaviorHints;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final AIODebianStreamData getStreamData() {
        return this.streamData;
    }

    @NotNull
    public final AIODebianStream copy(@Nullable String name, @Nullable String description, @Nullable String url, @Nullable AIODebianBehaviorHints behaviorHints, @Nullable AIODebianStreamData streamData) {
        return new AIODebianStream(name, description, url, behaviorHints, streamData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIODebianStream)) {
            return false;
        }
        AIODebianStream aIODebianStream = (AIODebianStream) other;
        return Intrinsics.areEqual(this.name, aIODebianStream.name) && Intrinsics.areEqual(this.description, aIODebianStream.description) && Intrinsics.areEqual(this.url, aIODebianStream.url) && Intrinsics.areEqual(this.behaviorHints, aIODebianStream.behaviorHints) && Intrinsics.areEqual(this.streamData, aIODebianStream.streamData);
    }

    public int hashCode() {
        return ((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.behaviorHints == null ? 0 : this.behaviorHints.hashCode())) * 31) + (this.streamData != null ? this.streamData.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AIODebianStream(name=" + this.name + ", description=" + this.description + ", url=" + this.url + ", behaviorHints=" + this.behaviorHints + ", streamData=" + this.streamData + ')';
    }

    public AIODebianStream(@Nullable String name, @Nullable String description, @Nullable String url, @Nullable AIODebianBehaviorHints behaviorHints, @Nullable AIODebianStreamData streamData) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.behaviorHints = behaviorHints;
        this.streamData = streamData;
    }

    public /* synthetic */ AIODebianStream(String str, String str2, String str3, AIODebianBehaviorHints aIODebianBehaviorHints, AIODebianStreamData aIODebianStreamData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : aIODebianBehaviorHints, (i & 16) != 0 ? null : aIODebianStreamData);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final AIODebianBehaviorHints getBehaviorHints() {
        return this.behaviorHints;
    }

    @Nullable
    public final AIODebianStreamData getStreamData() {
        return this.streamData;
    }
}
