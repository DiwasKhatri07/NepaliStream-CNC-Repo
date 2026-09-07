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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\\\u0010\u0015\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR)\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u001c"}, d2 = {"Lcom/AniVortex/ServerOption;", "", "key", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "downloadsEnabled", "", "downloads_enabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getKey", "()Ljava/lang/String;", "getName", "getDownloadsEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/AniVortex/ServerOption;", "equals", "other", "hashCode", "", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ServerOption {

    @JsonProperty("downloads_enabled")
    @Nullable
    private final Boolean downloadsEnabled;

    @JsonProperty("key")
    @Nullable
    private final String key;

    @JsonProperty("name")
    @Nullable
    private final String name;

    public ServerOption() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ServerOption copy$default(ServerOption serverOption, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serverOption.key;
        }
        if ((i & 2) != 0) {
            str2 = serverOption.name;
        }
        if ((i & 4) != 0) {
            bool = serverOption.downloadsEnabled;
        }
        return serverOption.copy(str, str2, bool);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getDownloadsEnabled() {
        return this.downloadsEnabled;
    }

    @NotNull
    public final ServerOption copy(@JsonProperty("key") @Nullable String key, @JsonProperty("name") @Nullable String name, @JsonProperty("downloads_enabled") @Nullable Boolean downloadsEnabled) {
        return new ServerOption(key, name, downloadsEnabled);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerOption)) {
            return false;
        }
        ServerOption serverOption = (ServerOption) other;
        return Intrinsics.areEqual(this.key, serverOption.key) && Intrinsics.areEqual(this.name, serverOption.name) && Intrinsics.areEqual(this.downloadsEnabled, serverOption.downloadsEnabled);
    }

    public int hashCode() {
        return ((((this.key == null ? 0 : this.key.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.downloadsEnabled != null ? this.downloadsEnabled.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ServerOption(key=" + this.key + ", name=" + this.name + ", downloadsEnabled=" + this.downloadsEnabled + ')';
    }

    public ServerOption(@JsonProperty("key") @Nullable String key, @JsonProperty("name") @Nullable String name, @JsonProperty("downloads_enabled") @Nullable Boolean downloadsEnabled) {
        this.key = key;
        this.name = name;
        this.downloadsEnabled = downloadsEnabled;
    }

    public /* synthetic */ ServerOption(String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool);
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Boolean getDownloadsEnabled() {
        return this.downloadsEnabled;
    }
}
